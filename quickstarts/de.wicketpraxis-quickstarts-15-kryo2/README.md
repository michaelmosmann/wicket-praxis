# Wicket Page Serializer und Performanceoptimierung

Wicket bildet den Zustand einer Anwendung, einer Webseite nicht wie andere Frameworks über Parameter in der Url ab. Wicket-Komponenten können viel mehr ihren eigenen Zustand über normale Java-Sprachmittel abbilden. Eine Komponente kann auf diese Weise die komplexesten Informationen halten, die möglicherweise sehr schwer über Url-Parameter abgebildet werden könnten. Das hat Vorteile, aber eben auch Nachteile. Der vermutlich größte Nachteil ist der Speicherbedarf, denn die Komponenten müssen für jeden Nutzer getrennt erzeugt und verwaltet werden. Anwendungen, die den Zustand einer Nutzerinteraktion immer über Url-Parameter abbilden, können nach dem ausliefern der Seite alle temporär erzeugten Daten verwerfen.

Wicket arbeitet anders. In Wicket ist eine Seite eine Sammlung verschiedenster Komponenten und Zustände in beliebigen Objekten. Wenn der Nutzer eine Aktion auf der Seite auslöst, wird die passende Komponente in diesem Komponentenbaum gesucht und die entsprechende Methode aufgerufen. Jede Interaktion erzeugt einen neuen Zustand und Wicket erzeugt eine neue Version der Seite für den Fall, dass der Nutzer z.B. mit dem Browser-Back-Buttom auf eine ältere Seite mit einem anderen Zustand zurück navigiert. Da der Arbeitsspeicher meist ein knappes Gut ist, werden die älteren Versionen einer Seite als Objektgraph mit all den Zuständen serialisiert und auf einem Datenträger abgelegt. Und hier wird es nun spannend.

Je mehr Zustand die Komponenten halten, je mehr Daten dafür notwendig sind, desto größer ist natürlich der Speicherbedarf zu Laufzeit aber auch der Platzbedarf auf dem Datenträger. Um nicht unnötig den Speicher und die Festplatte mit temporären Daten zu belasten, wird nach dem Ausliefern der Ergebnisseite für alle Komponenten die detach()-Methode aufgerufen, die sich darum kümmern muss, alles was für den Zustand der Komponente irrelevant ist, aufzuräumen.

## Überraschung vorraus

Nun hat man seine Wicket-Komponenten geschrieben und vermutet, dass man alles richtig gemacht hat oder hat einfach akzeptiert, dass z.B. der Speicherbedarf so hoch sein muss wie er eben gerade ist. Wenn man genügend Speicher hat, muss man ja nichts verändern, aber das ist vermutlich selten der Fall. Zum Glück bietet die Vorgehensweise, die Wicket an den Tag legt sehr interessante Möglichkeiten, um verschiedeneste Optimierungen vorzunehmen.

Wenn die Menge der Daten, die auf Festplatte geschrieben werden sehr hoch ist und die die CPU's im Rechner eher langweilen, kann man recht günstig Plattenplatz und Rechnengeschwindigkeit eintauschen (typische Kompression 70%, Mehrbelastung der CPU vermutlich 1-5%). Dafür benutzt man statt dem Standard-Serializer einfach die DeflatedJavaSerializer-Implementierung. **Vorsicht: die Daten, die mit dem Standard-Serializer auf die Festplatte geschrieben wurden, können nicht zurückgelesen werden.**

Besser wäre es natürlich, gleich von Anfang an weniger Temporärdaten zu erzeugen. Doch was genau welchen Platz im Speicher und später auf der Festplatte belegt, ist meist nicht ganz so einfach zu ermitteln.

## Der Anfang

Zu erst habe ich versucht, die Funktion, die bei Wicket für die aufschlußreiche Darstellung sorgt, welche Komponente nicht serialisierbare Objekte enthält entsprechend zu erweitern. Allerdings steigt man da in eine der eher nicht so gut gelüfteten Kammern von Java hinunter und kann sich sicher leicht verirren, so das eine andere Alternative gefunden werden musste. Zum Glück hatten dieses Gefühl wohl auch andere und haben das Projekt Kryo gestartet (http://code.google.com/p/kryo/). Kryo ist eine Alternative zur Serialisierung von Javaobjekten, die sehr konfigurierbar und trotz Reflection auch schneller und kompakter serialisieren soll.

Dann gab es recht schnell bei wicketstuff ein Projekt, dass Kryo in Wicket integriert hat. Allerdings bisher nur für die Version 1.x. Ich habe das dann für Kryo2 nachgeholt und entsprechend modularisiert, so dass man in den Serialisierungsprozess eingreifen kann und auf diese Weise verschiedene Informationen ermitteln kann. Doch dazu später mehr.

## Setup

Zuerst muss man sein Wicket-Projekt um eine Dependency erweitern:

	<dependency>
		<groupId>org.wicketstuff</groupId>
		<artifactId>wicketstuff-serializer-kryo2</artifactId>
		<version>${wicket.version}</version>
	</dependency>
	
Dabei gibt es sowohl für Wicket 1.5 (ab Version 1.5.9) als auch für Wicket 6 (ab Version 6.2.1) eine Version in Maven Central.

Dann ergänzen wir unsere WebApplication-Klasse in der init()-Methode um folgende Codezeilen:

		// output of report of type sizes, sorted tree report (by size), aggregated tree 
		ISerializedObjectTreeProcessor typeAndSortedTreeAndCollapsedSortedTreeProcessors = TreeProcessors.listOf(
			new TypeSizeReport(), new SortedTreeSizeReport(), new SimilarNodeTreeTransformator(
				new SortedTreeSizeReport()));

		// strips class object writes from tree
		TreeTransformator treeProcessors = new TreeTransformator(
			typeAndSortedTreeAndCollapsedSortedTreeProcessors,
			TreeTransformator.strip(new TypeFilter(Class.class)));

		// serialization listener notified on every written object
		ISerializationListener serializationListener = SerializationListeners.listOf(
			new DefaultJavaSerializationValidator(), new AnalyzingSerializationListener(
				new NativeTypesAsLabel(new ComponentIdAsLabel()), treeProcessors));

		// customized serializer
		InspectingKryoSerializer serializer = new InspectingKryoSerializer(Bytes.megabytes(30L),
			serializationListener);

		// set custom serializer as default
		getFrameworkSettings().setSerializer(serializer);
		
		getStoreSettings().setAsynchronous(false);
		getStoreSettings().setInmemoryCacheSize(0);
		getPageSettings().setVersionPagesByDefault(true);

Ab sofort wird für jede Seite, die serialisiert wird, eine detailierte Übersicht über die verwendeten Komponenten und den Speicherbedarf ausgegeben.

## Beispielausgabe

Wenn nun eine Seite von Wicket serialisiert wird, dann wird während des Schreibens des Objektgraphen die Anzahl der geschriebenen Bytes ermittelt und den passenden Objekten zugeteilt. Dabei gibt es gewisse Unschärfen. Wenn ein Objekt referenziert wird, wird nur das erste mal das Objekt selbst geschrieben. Jedes weitere mal wird nur eine Referenz auf das Objekt serialisiert, was natürlich viel weniger Platz in Anspruch nimmt. Insofern ist die Auswertung immer dann mit Vorsicht zu genießen, wenn ein Objekt an verschiedenen Stellen referenziert wird und nur einer den "Zuschlag" erhält.

Die Ausgabe und der ganze Serialisierungsprozess ist hochgradig anpassbar. In der Beispielkonfiguration entsteht für eine Beispielseite folgendes Ergebnis:

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.models.ModelsV1Page, id = 4, render count = 1]'
DEBUG - TypeSizeReport             - 
===================================================================
|Type........................................................bytes|
-------------------------------------------------------------------
|de.wicketpraxis.usecase.models.ModelsV1Page...................133|
|org.apache.wicket.markup.html.basic.Label.....................102|
|java.lang.Integer..............................................21|
|java.lang.String................................................9|
|de.wicketpraxis.usecase.models.ModelsV1Page$1...................3|
|de.wicketpraxis.usecase.models.ModelsV1Page$2...................3|
|org.apache.wicket.request.mapper.parameter.PageParameters.......3|
|[Ljava.lang.Object;.............................................2|
===================================================================

DEBUG - TreeSizeReport             - 
===========================================================================================
|  #|Type.............................................................%|.sum|.local|.child|
-------------------------------------------------------------------------------------------
| #0|de.wicketpraxis.usecase.models.ModelsV1Page(4)................100%|.276|...129|...147|
| #4|  [Ljava.lang.Object;..........................................48%|.135|.....2|...133|
|#12|    org.apache.wicket.markup.html.basic.Label(now2)............24%|..67|....51|....16|
|#15|      java.lang.Integer(=1343434906)............................1%|...5|.....5|.....0|
|#17|      java.lang.String("now2")..................................1%|...5|.....5|.....0|
|#14|      org.apache.wicket.model.LoadableDetachableModel...........1%|...4|.....3|.....1|
| #0|        de.wicketpraxis.usecase.models.ModelsV1Page(4)..........0%|...1|.....1|.....0|
|#16|      java.lang.Integer(=-1)....................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.models.ModelsV1Page(4)............0%|...1|.....1|.....0|
| #5|    org.apache.wicket.markup.html.basic.Label(now).............23%|..66|....51|....15|
| #9|      java.lang.Integer(=1343434906)............................1%|...5|.....5|.....0|
| #8|      org.apache.wicket.model.LoadableDetachableModel...........1%|...4|.....3|.....1|
| #0|        de.wicketpraxis.usecase.models.ModelsV1Page(4)..........0%|...1|.....1|.....0|
|#11|      java.lang.String("now")...................................1%|...4|.....4|.....0|
|#10|      java.lang.Integer(=-1)....................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.models.ModelsV1Page(4)............0%|...1|.....1|.....0|
|#18|  java.lang.Integer(=1342845082)................................1%|...5|.....5|.....0|
|#22|  org.apache.wicket.request.mapper.parameter.PageParameters.....1%|...3|.....3|.....0|
| #2|  java.lang.Integer(=1).........................................0%|...1|.....1|.....0|
|#19|  java.lang.Integer(=-1)........................................0%|...1|.....1|.....0|
|#20|  java.lang.Integer(=4).........................................0%|...1|.....1|.....0|
|#23|  java.lang.Integer(=1).........................................0%|...1|.....1|.....0|
===========================================================================================

DEBUG - TreeSizeReport             - 
============================================================================================
|   #|Type.............................................................%|.sum|.local|.child|
--------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.models.ModelsV1Page(4)................100%|.276|...129|...147|
|  #4|  [Ljava.lang.Object;..........................................48%|.135|.....2|...133|
| #12|    org.apache.wicket.markup.html.basic.Label(now2)............24%|..67|....51|....16|
|null|      java.lang.Integer(=1343434906|=-1)........................2%|...6|.....6|.....0|
| #17|      java.lang.String("now2")..................................1%|...5|.....5|.....0|
| #14|      org.apache.wicket.model.LoadableDetachableModel...........1%|...4|.....3|.....1|
|  #0|        de.wicketpraxis.usecase.models.ModelsV1Page(4)..........0%|...1|.....1|.....0|
|  #0|      de.wicketpraxis.usecase.models.ModelsV1Page(4)............0%|...1|.....1|.....0|
|  #5|    org.apache.wicket.markup.html.basic.Label(now).............23%|..66|....51|....15|
|null|      java.lang.Integer(=1343434906|=-1)........................2%|...6|.....6|.....0|
|  #8|      org.apache.wicket.model.LoadableDetachableModel...........1%|...4|.....3|.....1|
|  #0|        de.wicketpraxis.usecase.models.ModelsV1Page(4)..........0%|...1|.....1|.....0|
| #11|      java.lang.String("now")...................................1%|...4|.....4|.....0|
|  #0|      de.wicketpraxis.usecase.models.ModelsV1Page(4)............0%|...1|.....1|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1|=4)......................3%|...9|.....9|.....0|
| #22|  org.apache.wicket.request.mapper.parameter.PageParameters.....1%|...3|.....3|.....0|
============================================================================================

Die erste Tabelle enthält eine Aufschlüsselung nach Typen, die zweite Tabelle stellt den fast ungefilterten Komponentenbaum dar (die Klasse Component verwaltet Kindkomponenten und andere Dinge in einem Object-Array, weshalb im Baum [Ljava.lang.Object auftaucht). Die dritte Tabelle versucht gleiche Zweige zusammen zu fassen. Dabei werden die Größen aufadiert und die Labels (in Klammern dahinter) vereint. Die Angaben in den Klammern hinter den Klassennamen stellen ein Label für die Klasse dar. Bei Wicket-Komponenten ist das die Id, bei nativen Datentypen der Wert.

Und das nächste Mal sehen wir uns an, was für interessante Entdeckungen man damit machen kann. Doch zuvor ein Hinweis. Das sollten sie so nie in Produktivumgebungen einsetzen. Auch kann es bei bestehenden Anwendung zu sehr sehr umfangreichen Ausgaben kommen, so dass man in einer IDE die Logausgabe vielleicht besser in eine Datei umlenkt.

Viel Spass mit dem Experimentieren.

Den Code für die Beispielen findet man unter https://github.com/michaelmosmann/wicket-praxis/tree/master/quickstarts/de.wicketpraxis-quickstarts-15-kryo2




