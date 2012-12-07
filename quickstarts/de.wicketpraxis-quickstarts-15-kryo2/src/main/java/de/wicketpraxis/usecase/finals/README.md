# Wicket Page Serializer und Performanceoptimierung – Teil 3 - Unerwünschte Gäste

Hier folgt der 3. Teil der Serie (siehe [http://www.wicket-praxis.de/blog/2012/11/27/wicket-page-serializer-und-performanceoptimierung-teil-1/]). Dabei nähern wir uns dem Thema von vielleicht unerwarteter Seite.

## Downside of final

Normalerweise kann ich die Verwendung von final in Variablendeklarationen immer begrüßen. Allerdings gibt es Nebeneffekte, die bekannt sein sollten und die unter Umständen unerwünschte Effekte in der Verwendung mit Wicket-Komponenten haben. Stellen wir uns folgendes Beispiel vor:

public class FinalsV1Page extends WebPage
{
	public FinalsV1Page()
	{
		final Irrelevant irrelevantToLabel=new Irrelevant();
		
		add(new Label("label", "Fun"){
			
			@Override
			protected void onInitialize()
			{
				super.onInitialize();
				if (false) {
					setDefaultModelObject(irrelevantToLabel.text);
				}
			}
		});
		setStatelessHint(false);
	}
	
	static class Irrelevant implements Serializable {
		String text="this could be something big.";
		byte[] veryBig=new byte[1024];
	}
}

Das Beispiel ist natürlich konstruiert und kommt so in der freien Wildbahn nicht direkt vor. Allerdings ist das Muster häufiger anzutreffen. Man verwendet für Methodenparamter den Zusatz final oder man möchte auf eine Methode einer anderen Klasseninstanz in einer anonymen Klasse zugreifen und markiert die Instanzvariable absichtlich mit final.

Das ich die Verwendung des Zugriffs auf die Instanz verhindert habe (if false), soll verdeutlichen, dass kein Zugriff auf die Instanz stattfinden muss, sondern das es reicht, das das theoretisch möglich wäre.

Das Markup ist auch für dieses Beispiel irrelevant. Wenn die Seite nun Serialisiert wird, bekommen wir folgende Ausgabe:

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.finals.FinalsV1Page, id = 1, render count = 1]'
DEBUG - TypeSizeReport             - 
===================================================================
|Type........................................................bytes|
-------------------------------------------------------------------
|[B...........................................................1027|
|de.wicketpraxis.usecase.finals.FinalsV1Page...................157|
|de.wicketpraxis.usecase.finals.FinalsV1Page$1..................92|
|java.lang.String...............................................39|
|java.lang.Integer..............................................15|
|org.apache.wicket.request.mapper.parameter.PageParameters.......3|
|org.apache.wicket.model.Model...................................2|
|de.wicketpraxis.usecase.finals.FinalsV1Page$Irrelevant..........1|
===================================================================

DEBUG - TreeSizeReport             - 
============================================================================================
|  #|Type.............................................................%|..sum|.local|.child|
--------------------------------------------------------------------------------------------
| #0|de.wicketpraxis.usecase.finals.FinalsV1Page(1)................100%|.1336|...155|..1181|
| #4|  org.apache.wicket.markup.html.basic.Label(label).............87%|.1169|....92|..1077|
|#13|    de.wicketpraxis.usecase.finals.FinalsV1Page$Irrelevant.....79%|.1057|.....1|..1056|
|#15|      [B.......................................................76%|.1027|..1027|.....0|
|#14|      java.lang.String("this...")...............................2%|...29|....29|.....0|
| #6|    org.apache.wicket.model.Model...............................0%|....6|.....2|.....4|
| #8|      java.lang.String("Fun")...................................0%|....4|.....4|.....0|
|#11|    java.lang.String("labe...").................................0%|....6|.....6|.....0|
| #9|    java.lang.Integer(=1343434906)..............................0%|....5|.....5|.....0|
| #0|    de.wicketpraxis.usecase.finals.FinalsV1Page(1)..............0%|....2|.....2|.....0|
|#10|    java.lang.Integer(=-1)......................................0%|....1|.....1|.....0|
|#16|  java.lang.Integer(=1342845082)................................0%|....5|.....5|.....0|
|#20|  org.apache.wicket.request.mapper.parameter.PageParameters.....0%|....3|.....3|.....0|
| #2|  java.lang.Integer(=1).........................................0%|....1|.....1|.....0|
|#17|  java.lang.Integer(=-1)........................................0%|....1|.....1|.....0|
|#18|  java.lang.Integer(=1).........................................0%|....1|.....1|.....0|
|#21|  java.lang.Integer(=1).........................................0%|....1|.....1|.....0|
============================================================================================

DEBUG - TreeSizeReport             - 
=============================================================================================
|   #|Type.............................................................%|..sum|.local|.child|
---------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.finals.FinalsV1Page(1)................100%|.1336|...155|..1181|
|  #4|  org.apache.wicket.markup.html.basic.Label(label).............87%|.1169|....92|..1077|
| #13|    de.wicketpraxis.usecase.finals.FinalsV1Page$Irrelevant.....79%|.1057|.....1|..1056|
| #15|      [B.......................................................76%|.1027|..1027|.....0|
| #14|      java.lang.String("this...")...............................2%|...29|....29|.....0|
|  #6|    org.apache.wicket.model.Model...............................0%|....6|.....2|.....4|
|  #8|      java.lang.String("Fun")...................................0%|....4|.....4|.....0|
|null|    java.lang.Integer(=1343434906|=-1)..........................0%|....6|.....6|.....0|
| #11|    java.lang.String("labe...").................................0%|....6|.....6|.....0|
|  #0|    de.wicketpraxis.usecase.finals.FinalsV1Page(1)..............0%|....2|.....2|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1).........................0%|....9|.....9|.....0|
| #20|  org.apache.wicket.request.mapper.parameter.PageParameters.....0%|....3|.....3|.....0|
=============================================================================================

Wie man deutlich sieht, hat er alles, was in der eigentlich unbenutzen Instanz enhalten war mit serialisiert. Das kann oft unumgänglich sein, allerdings glaube ich, dass man eben so oft zu besseren Lösungen kommt. Zum Vergleich ändern wir mal die eine Kleinigkeit:

public class FinalsV2Page extends WebPage
{
	public FinalsV2Page()
	{
		final Irrelevant irrelevantToLabel=new Irrelevant();
		
		add(new Label("label", "Fun"){
			
			@Override
			protected void onInitialize()
			{
				super.onInitialize();
				if (false) {
					setDefaultModelObject("this could be something big.");
				}
			}
		});
		setStatelessHint(false);
	}
	
	static class Irrelevant implements Serializable {
		String text="this could be something big.";
		byte[] veryBig=new byte[1024];
	}
}

Wenn man sich jetzt ansieht, was davon in der Serialisierung übrig bleibt, dann erkennt man recht leicht den Unterschied:

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.finals.FinalsV2Page, id = 2, render count = 1]'
DEBUG - TypeSizeReport             - 
===================================================================
|Type........................................................bytes|
-------------------------------------------------------------------
|de.wicketpraxis.usecase.finals.FinalsV2Page...................157|
|de.wicketpraxis.usecase.finals.FinalsV2Page$1..................36|
|java.lang.Integer..............................................15|
|java.lang.String...............................................10|
|org.apache.wicket.request.mapper.parameter.PageParameters.......3|
|org.apache.wicket.model.Model...................................2|
===================================================================

DEBUG - TreeSizeReport             - 
===========================================================================================
|  #|Type.............................................................%|.sum|.local|.child|
-------------------------------------------------------------------------------------------
| #0|de.wicketpraxis.usecase.finals.FinalsV2Page(2)................100%|.223|...155|....68|
| #4|  org.apache.wicket.markup.html.basic.Label(label).............25%|..56|....36|....20|
| #6|    org.apache.wicket.model.Model...............................2%|...6|.....2|.....4|
| #8|      java.lang.String("Fun")...................................1%|...4|.....4|.....0|
|#11|    java.lang.String("labe...").................................2%|...6|.....6|.....0|
| #9|    java.lang.Integer(=1343434906)..............................2%|...5|.....5|.....0|
| #0|    de.wicketpraxis.usecase.finals.FinalsV2Page(2)..............0%|...2|.....2|.....0|
|#10|    java.lang.Integer(=-1)......................................0%|...1|.....1|.....0|
|#12|  java.lang.Integer(=1342845082)................................2%|...5|.....5|.....0|
|#16|  org.apache.wicket.request.mapper.parameter.PageParameters.....1%|...3|.....3|.....0|
| #2|  java.lang.Integer(=1).........................................0%|...1|.....1|.....0|
|#13|  java.lang.Integer(=-1)........................................0%|...1|.....1|.....0|
|#14|  java.lang.Integer(=2).........................................0%|...1|.....1|.....0|
|#17|  java.lang.Integer(=1).........................................0%|...1|.....1|.....0|
===========================================================================================

DEBUG - TreeSizeReport             - 
============================================================================================
|   #|Type.............................................................%|.sum|.local|.child|
--------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.finals.FinalsV2Page(2)................100%|.223|...155|....68|
|  #4|  org.apache.wicket.markup.html.basic.Label(label).............25%|..56|....36|....20|
|  #6|    org.apache.wicket.model.Model...............................2%|...6|.....2|.....4|
|  #8|      java.lang.String("Fun")...................................1%|...4|.....4|.....0|
|null|    java.lang.Integer(=1343434906|=-1)..........................2%|...6|.....6|.....0|
| #11|    java.lang.String("labe...").................................2%|...6|.....6|.....0|
|  #0|    de.wicketpraxis.usecase.finals.FinalsV2Page(2)..............0%|...2|.....2|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1|=2)......................4%|...9|.....9|.....0|
| #16|  org.apache.wicket.request.mapper.parameter.PageParameters.....1%|...3|.....3|.....0|
============================================================================================

An diesem Beispiel kann man vielleicht sehen, dass es eine gute Strategie sein kann, Komponenten so klein wie möglich zu schneiden. Zum einen wird die Klasse bei mehrfacher Verwendung nur einmal serialisiert und außerdem läuft man nicht so große Gefahr, dass viele unerwünschte Dinge ebenfalls mitserialisiert werden. Und natürlich hat das auch Auswirkungen auf den Speicherverbrauch: solange eine Referenz auf ein Objekt gehalten wird, kann es nicht durch die Garbage-Collection aufgeräumt werden.

Wie kann man nun verhindern, dass so etwas unabsichtlich passiert: am einfachsten ist es, wenn man versucht, so wenig wie möglich anonyme Klassen zu verwenden. Das sollte sich schnell in vielfacher Hinsicht auszahlen.
