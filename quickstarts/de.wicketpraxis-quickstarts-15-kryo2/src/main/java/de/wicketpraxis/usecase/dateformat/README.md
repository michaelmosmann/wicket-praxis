# Wicket Page Serializer und Performanceoptimierung – Teil 2

Wie im Teil 1 [http://www.wicket-praxis.de/blog/2012/11/27/wicket-page-serializer-und-performanceoptimierung-teil-1/] versprochen, werde ich im zweiten Teil an einem konkreten Beispiel demonstrieren, welche Fragen man vielleicht mit diesem neuen Werkzeug etwas besser beantworten kann.

## Beispiel Datumsanzeige

Früher (und eher nicht später) wird man in einer Wicket-Anwendung ein Datum zur Anzeige bringen. Die einfachste Methode ist natürlich ein Label und ein IModel<Date> als Model-Instanz. Normalerweise möchte man aber eine ganz bestimmte Darstellung, so dass man nicht umhin kommt, das Datum irgendwie zu konvertieren. Ein möglicher Ansatz könnte in Abwandlungen wie folgt aussehen:

public class DateModel extends LoadableDetachableModel<Date>
{
	@Override
	protected Date load()
	{
		return new Date();
	}
}

public class DateFormatV1Page extends WebPage
{
	public DateFormatV1Page()
	{
		add(new Label("now", new DateToStringModel(new DateModel())));
		add(new Label("now2", new DateToStringModel(new DateModel())));

		setStatelessHint(false);
	}

	static class DateToStringModel extends LoadableDetachableModel<String>
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		private final IModel<Date> dateModel;

		public DateToStringModel(IModel<Date> dateModel)
		{
			this.dateModel = dateModel;
		}

		@Override
		protected String load()
		{
			return dateFormat.format(dateModel.getObject());
		}

		@Override
		protected void onDetach()
		{
			super.onDetach();
			dateModel.detach();
		}
	}
}

Das Markup spielt keine große Rolle, sollte aber nicht unerwähnt bleiben:

<html>
	<head>
		<title>Date Format</title>
	</head>
	<body>
		<h1>Date Format</h1>
		Now: <span wicket:id="now"></span><br>
		Now: <span wicket:id="now2"></span><br>
	</body>
</html>

Der Aufruf von setStatelessHint(false) im Konstruktor sorgt in diesem und in den folgenden Beispielen dafür, das Wicket annehmen muss, dass die Seite nicht zustandslos ist. Zustandslose Seiten werden nicht serialisiert, weil nicht zu erwarten ist, dass man diese Instanz später noch einmal benötigt.

Wenn diese Seite nun serialisiert wird, ergibt sich folgendes Bild:

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.dateformat.DateFormatV1Page, id = 0, render count = 1]'
DEBUG - TypeSizeReport             - 
===============================================================================
|Type....................................................................bytes|
-------------------------------------------------------------------------------
|[Ljava.lang.String;.......................................................287|
|de.wicketpraxis.usecase.dateformat.DateFormatV1Page.......................139|
|java.lang.String..........................................................112|
|org.apache.wicket.markup.html.basic.Label..................................83|
|java.text.SimpleDateFormat.................................................80|
|de.wicketpraxis.usecase.dateformat.DateFormatV1Page$DateToStringModel......80|
|java.lang.Integer..........................................................58|
|java.util.GregorianCalendar................................................46|
|java.lang.Character........................................................40|
|java.text.DecimalFormat....................................................36|
|java.util.Date.............................................................20|
|java.lang.Byte.............................................................12|
|java.lang.Boolean..........................................................10|
|java.util.Locale............................................................6|
|java.text.DateFormatSymbols.................................................4|
|java.math.RoundingMode......................................................3|
|org.apache.wicket.request.mapper.parameter.PageParameters...................3|
|[Ljava.lang.Object;.........................................................2|
|de.wicketpraxis.usecase.dateformat.DateModel................................2|
|java.text.DecimalFormatSymbols..............................................2|
===============================================================================

DEBUG - TreeSizeReport             - 
=============================================================================================================
|   #|Type.............................................................................%|..sum|.local|.child|
-------------------------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)........................100%|.1025|...137|...888|
|  #4|  [Ljava.lang.Object;..........................................................85%|..876|.....2|...874|
|  #5|    org.apache.wicket.markup.html.basic.Label(now).............................64%|..658|....77|...581|
|  #8|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page$DateToStringModel....55%|..570|....75|...495|
| #10|        java.text.SimpleDateFormat.............................................48%|..494|....72|...422|
| #16|          java.text.DateFormatSymbols..........................................23%|..242|.....2|...240|
| #25|            [Ljava.lang.String;.................................................7%|...76|....76|.....0|
| #28|            [Ljava.lang.String;.................................................5%|...56|....56|.....0|
| #26|            [Ljava.lang.String;.................................................3%|...39|....39|.....0|
| #19|            java.lang.String("GuMt...").........................................1%|...20|....20|.....0|
| #27|            [Ljava.lang.String;.................................................1%|...17|....17|.....0|
| #18|            [Ljava.lang.String;.................................................1%|...16|....16|.....0|
| #20|            java.util.Locale....................................................0%|...10|.....1|.....9|
| #21|              java.lang.String("DE")............................................0%|....3|.....3|.....0|
| #23|              java.lang.String("de")............................................0%|....3|.....3|.....0|
| #24|              java.lang.String("")..............................................0%|....2|.....2|.....0|
| #22|              java.lang.Integer(=-1)............................................0%|....1|.....1|.....0|
| #17|            [Ljava.lang.String;.................................................0%|....6|.....6|.....0|
| #30|          java.text.DecimalFormat..............................................12%|..125|....33|....92|
| #62|            java.text.DecimalFormatSymbols......................................4%|...45|.....1|....44|
| #63|              java.lang.String("�").............................................0%|....5|.....5|.....0|
| #64|              java.lang.String("€").............................................0%|....5|.....5|.....0|
| #70|              java.lang.String("∞").............................................0%|....5|.....5|.....0|
| #71|              java.lang.String("EUR")...........................................0%|....4|.....4|.....0|
| #68|              java.lang.String("E").............................................0%|....3|.....3|.....0|
| #65|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #66|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #67|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #69|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #72|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #73|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #74|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #75|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #76|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #78|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #20|              java.util.Locale..................................................0%|....1|.....1|.....0|
| #77|              java.lang.Integer(=3).............................................0%|....1|.....1|.....0|
| #38|            java.lang.Integer(=MAX).............................................0%|....5|.....5|.....0|
| #48|            java.lang.String("'-")..............................................0%|....3|.....3|.....0|
| #50|            java.lang.String("-")...............................................0%|....3|.....3|.....0|
| #39|            java.lang.Integer(=309).............................................0%|....2|.....2|.....0|
| #49|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #51|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #54|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #55|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #56|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #57|            java.lang.String("")................................................0%|....2|.....2|.....0|
| #58|            java.math.RoundingMode..............................................0%|....2|.....2|.....0|
| #31|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #32|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #33|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #34|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #35|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #36|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
| #37|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
| #40|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #41|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #42|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #43|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
| #44|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
| #45|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
| #46|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
| #47|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
| #52|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #53|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #59|            java.lang.Integer(=4)...............................................0%|....1|.....1|.....0|
| #60|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
| #79|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #12|          java.util.GregorianCalendar...........................................2%|...23|....23|.....0|
| #80|          java.lang.String("dd.M...")...........................................1%|...20|....20|.....0|
| #14|          java.util.Date........................................................0%|...10|....10|.....0|
| #20|          java.util.Locale......................................................0%|....1|.....1|.....0|
| #81|          java.lang.Integer(=1).................................................0%|....1|.....1|.....0|
| #83|        de.wicketpraxis.usecase.dateformat.DateModel............................0%|....1|.....1|.....0|
| #84|      java.lang.Integer(=1343434906)............................................0%|....5|.....5|.....0|
| #86|      java.lang.String("now")...................................................0%|....4|.....4|.....0|
| #85|      java.lang.Integer(=-1)....................................................0%|....1|.....1|.....0|
|  #0|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)....................0%|....1|.....1|.....0|
| #87|    org.apache.wicket.markup.html.basic.Label(now2)............................21%|..216|.....6|...210|
| #88|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page$DateToStringModel....19%|..198|.....5|...193|
| #89|        java.text.SimpleDateFormat.............................................18%|..192|.....8|...184|
| #92|          java.text.DateFormatSymbols...........................................7%|...81|.....2|....79|
| #94|            [Ljava.lang.String;.................................................5%|...56|....56|.....0|
| #93|            [Ljava.lang.String;.................................................1%|...17|....17|.....0|
| #17|            [Ljava.lang.String;.................................................0%|....1|.....1|.....0|
| #18|            [Ljava.lang.String;.................................................0%|....1|.....1|.....0|
| #19|            java.lang.String("GuMt...").........................................0%|....1|.....1|.....0|
| #20|            java.util.Locale....................................................0%|....1|.....1|.....0|
| #25|            [Ljava.lang.String;.................................................0%|....1|.....1|.....0|
| #26|            [Ljava.lang.String;.................................................0%|....1|.....1|.....0|
| #95|          java.text.DecimalFormat...............................................6%|...67|.....3|....64|
|#117|            java.text.DecimalFormatSymbols......................................2%|...28|.....1|....27|
|#118|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#119|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#120|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#121|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#122|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#123|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#124|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#125|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#126|              java.lang.Character...............................................0%|....2|.....2|.....0|
|#128|              java.lang.Character...............................................0%|....2|.....2|.....0|
| #63|              java.lang.String("�").............................................0%|....1|.....1|.....0|
| #64|              java.lang.String("€").............................................0%|....1|.....1|.....0|
| #68|              java.lang.String("E").............................................0%|....1|.....1|.....0|
| #70|              java.lang.String("∞").............................................0%|....1|.....1|.....0|
| #71|              java.lang.String("EUR")...........................................0%|....1|.....1|.....0|
| #20|              java.util.Locale..................................................0%|....1|.....1|.....0|
|#127|              java.lang.Integer(=3).............................................0%|....1|.....1|.....0|
|#103|            java.lang.Integer(=MAX).............................................0%|....5|.....5|.....0|
|#104|            java.lang.Integer(=309).............................................0%|....2|.....2|.....0|
| #96|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #97|            java.lang.Byte......................................................0%|....1|.....1|.....0|
| #98|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #99|            java.lang.Byte......................................................0%|....1|.....1|.....0|
|#100|            java.lang.Byte......................................................0%|....1|.....1|.....0|
|#101|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
|#102|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
|#105|            java.lang.Byte......................................................0%|....1|.....1|.....0|
|#106|            java.lang.Byte......................................................0%|....1|.....1|.....0|
|#107|            java.lang.Byte......................................................0%|....1|.....1|.....0|
|#108|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
|#109|            java.lang.Integer(=0)...............................................0%|....1|.....1|.....0|
|#110|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
|#111|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
|#112|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
| #48|            java.lang.String("'-")..............................................0%|....1|.....1|.....0|
| #49|            java.lang.String("")................................................0%|....1|.....1|.....0|
| #50|            java.lang.String("-")...............................................0%|....1|.....1|.....0|
| #51|            java.lang.String("")................................................0%|....1|.....1|.....0|
|#113|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
|#114|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #54|            java.lang.String("")................................................0%|....1|.....1|.....0|
| #55|            java.lang.String("")................................................0%|....1|.....1|.....0|
| #56|            java.lang.String("")................................................0%|....1|.....1|.....0|
| #57|            java.lang.String("")................................................0%|....1|.....1|.....0|
| #58|            java.math.RoundingMode..............................................0%|....1|.....1|.....0|
|#115|            java.lang.Integer(=4)...............................................0%|....1|.....1|.....0|
|#116|            java.lang.Integer(=1)...............................................0%|....1|.....1|.....0|
|#129|            java.lang.Boolean...................................................0%|....1|.....1|.....0|
| #90|          java.util.GregorianCalendar...........................................2%|...23|....23|.....0|
| #91|          java.util.Date........................................................0%|...10|....10|.....0|
| #20|          java.util.Locale......................................................0%|....1|.....1|.....0|
| #80|          java.lang.String("dd.M...")...........................................0%|....1|.....1|.....0|
|#130|          java.lang.Integer(=1).................................................0%|....1|.....1|.....0|
|#131|        de.wicketpraxis.usecase.dateformat.DateModel............................0%|....1|.....1|.....0|
|#132|      java.lang.Integer(=1343434906)............................................0%|....5|.....5|.....0|
|#134|      java.lang.String("now2")..................................................0%|....5|.....5|.....0|
|#133|      java.lang.Integer(=-1)....................................................0%|....1|.....1|.....0|
|  #0|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)....................0%|....1|.....1|.....0|
|#135|  java.lang.Integer(=1342845082)................................................0%|....5|.....5|.....0|
|#139|  org.apache.wicket.request.mapper.parameter.PageParameters.....................0%|....3|.....3|.....0|
|  #2|  java.lang.Integer(=1).........................................................0%|....1|.....1|.....0|
|#136|  java.lang.Integer(=-1)........................................................0%|....1|.....1|.....0|
|#137|  java.lang.Integer(=0).........................................................0%|....1|.....1|.....0|
|#140|  java.lang.Integer(=1).........................................................0%|....1|.....1|.....0|
=============================================================================================================

DEBUG - TreeSizeReport             - 
=============================================================================================================
|   #|Type.............................................................................%|..sum|.local|.child|
-------------------------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)........................100%|.1025|...137|...888|
|  #4|  [Ljava.lang.Object;..........................................................85%|..876|.....2|...874|
|  #5|    org.apache.wicket.markup.html.basic.Label(now).............................64%|..658|....77|...581|
|  #8|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page$DateToStringModel....55%|..570|....75|...495|
| #10|        java.text.SimpleDateFormat.............................................48%|..494|....72|...422|
| #16|          java.text.DateFormatSymbols..........................................23%|..242|.....2|...240|
|null|            [Ljava.lang.String;................................................20%|..210|...210|.....0|
| #19|            java.lang.String("GuMt...").........................................1%|...20|....20|.....0|
| #20|            java.util.Locale....................................................0%|...10|.....1|.....9|
|null|              java.lang.String("DE"|"de"|"")....................................0%|....8|.....8|.....0|
| #22|              java.lang.Integer(=-1)............................................0%|....1|.....1|.....0|
| #30|          java.text.DecimalFormat..............................................12%|..125|....33|....92|
| #62|            java.text.DecimalFormatSymbols......................................4%|...45|.....1|....44|
|null|              java.lang.String("�"|"€"|"E"|"∞"|"EUR")...........................2%|...22|....22|.....0|
|null|              java.lang.Character...............................................1%|...20|....20|.....0|
| #20|              java.util.Locale..................................................0%|....1|.....1|.....0|
| #77|              java.lang.Integer(=3).............................................0%|....1|.....1|.....0|
|null|            java.lang.String("'-"|""|"-").......................................1%|...18|....18|.....0|
|null|            java.lang.Integer(=0|=MAX|=309|=1|=4)...............................1%|...16|....16|.....0|
|null|            java.lang.Byte......................................................0%|....6|.....6|.....0|
|null|            java.lang.Boolean...................................................0%|....5|.....5|.....0|
| #58|            java.math.RoundingMode..............................................0%|....2|.....2|.....0|
| #12|          java.util.GregorianCalendar...........................................2%|...23|....23|.....0|
| #80|          java.lang.String("dd.M...")...........................................1%|...20|....20|.....0|
| #14|          java.util.Date........................................................0%|...10|....10|.....0|
| #20|          java.util.Locale......................................................0%|....1|.....1|.....0|
| #81|          java.lang.Integer(=1).................................................0%|....1|.....1|.....0|
| #83|        de.wicketpraxis.usecase.dateformat.DateModel............................0%|....1|.....1|.....0|
|null|      java.lang.Integer(=1343434906|=-1)........................................0%|....6|.....6|.....0|
| #86|      java.lang.String("now")...................................................0%|....4|.....4|.....0|
|  #0|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)....................0%|....1|.....1|.....0|
| #87|    org.apache.wicket.markup.html.basic.Label(now2)............................21%|..216|.....6|...210|
| #88|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page$DateToStringModel....19%|..198|.....5|...193|
| #89|        java.text.SimpleDateFormat.............................................18%|..192|.....8|...184|
| #92|          java.text.DateFormatSymbols...........................................7%|...81|.....2|....79|
|null|            [Ljava.lang.String;.................................................7%|...77|....77|.....0|
| #19|            java.lang.String("GuMt...").........................................0%|....1|.....1|.....0|
| #20|            java.util.Locale....................................................0%|....1|.....1|.....0|
| #95|          java.text.DecimalFormat...............................................6%|...67|.....3|....64|
|#117|            java.text.DecimalFormatSymbols......................................2%|...28|.....1|....27|
|null|              java.lang.Character...............................................1%|...20|....20|.....0|
|null|              java.lang.String("�"|"€"|"E"|"∞"|"EUR")...........................0%|....5|.....5|.....0|
| #20|              java.util.Locale..................................................0%|....1|.....1|.....0|
|#127|              java.lang.Integer(=3).............................................0%|....1|.....1|.....0|
|null|            java.lang.Integer(=0|=MAX|=309|=1|=4)...............................1%|...16|....16|.....0|
|null|            java.lang.String("'-"|""|"-").......................................0%|....8|.....8|.....0|
|null|            java.lang.Byte......................................................0%|....6|.....6|.....0|
|null|            java.lang.Boolean...................................................0%|....5|.....5|.....0|
| #58|            java.math.RoundingMode..............................................0%|....1|.....1|.....0|
| #90|          java.util.GregorianCalendar...........................................2%|...23|....23|.....0|
| #91|          java.util.Date........................................................0%|...10|....10|.....0|
| #20|          java.util.Locale......................................................0%|....1|.....1|.....0|
| #80|          java.lang.String("dd.M...")...........................................0%|....1|.....1|.....0|
|#130|          java.lang.Integer(=1).................................................0%|....1|.....1|.....0|
|#131|        de.wicketpraxis.usecase.dateformat.DateModel............................0%|....1|.....1|.....0|
|null|      java.lang.Integer(=1343434906|=-1)........................................0%|....6|.....6|.....0|
|#134|      java.lang.String("now2")..................................................0%|....5|.....5|.....0|
|  #0|      de.wicketpraxis.usecase.dateformat.DateFormatV1Page(0)....................0%|....1|.....1|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1|=0)......................................0%|....9|.....9|.....0|
|#139|  org.apache.wicket.request.mapper.parameter.PageParameters.....................0%|....3|.....3|.....0|
=============================================================================================================

## Tabelle 1

Ich versuche mal, die obere Ausgabe etwas zu erklären. In der ersten Tabelle, die wir im Log finden, wird versucht, die Menge der geschriebenen Daten einem Typ zuzuordnen. Dabei kann es zu Ungenauigkeiten kommen, wenn Typen sich selbst enthalten können (ArrayList von Objekten, die wieder eine ArrayList benutzen). Die Typbezeichnung ergibt sich meist aus getClass().toString() (für anonyme Klassen wird die Elternklasse ausgewählt). Was in dieser Tabelle schon auffällt: da werden viele Strings geschrieben.

## Tabelle 2

In der zweiten Tabelle befinden sich 6 Spalten (5 und eine Doppelbelegung). Die erste Spalte (#) gibt eine ObjektID an. Wird die selbe ID in mehr als einer Zeile verwendet, dann wird an der zweiten Stelle ebenfalls eine Referenz auf das Objekt gehalten und natürlich mit serialisiert. Ein Objekt wird immer beim ersten Treffer vollständig serialisiert. Das bedeutet, wenn 3 Objekte eine Referenz auf A haben, bekommt das erste Objekt den größten Zuschlag. Das kann man sicher irgendwie korrigieren, aber meist reicht dieses Wissen aus, um trotzdem sehr viel (wenn auch erst mal etwas gefühlt unpräzise) Erkenntnisse zu gewinnen. Die zweite Spalte (Type) gibt wie in der ersten Tabelle den Typ an. Da hier immer die selben Rohdaten benutzt werden (die zweite Tabelle ist eigentlich die ungefilterte Datenquelle, die anderen Tabellen sind aggregierte Daten davon), gelten die selben Regeln. Hinter dem Typ wird in Klammern für Komponenten die WicketID und für einfache Datentypen der Wert angezeigt (bei Integer ist immer ein = davor). Dann gibt es die dritte Spalte (%, die Doppelbelegung). Dort wird anzeigt welchen Platzanteil das Objekt inklusive aller Unterobjekte einnimmt. Das soll helfen, die großen Fische zu finden. Die drei letzten Spalten geben von hinten nach vorne die Größe aller Kinder (child), den Datenumfang des Objektes selbst (local) und die Summe beider Zahlen (sum) an.

Was an der zweiten Tabelle auffällt ist die große Anzahl an Objekten unterhalb von java.text.SimpleDateFormat. Wenn man sich dann die Gesamtgröße anschaut, werden für dieses Beispiel rund 1kb an Daten serialisiert. Das hört sich nicht viel an, verändert sich aber dramatisch, wenn man sich das ganze in einer langen Tabelle vorstellt. Die erste Instanz kommt auf 48% und die zweite auf 18% des Platzbedarfs der Seite. Das ist eigentlich recht viel. Wenn man mal in die Untiefen der Klassen hinabsteigt, stößt man in dem Fall auf die Klasse java.text.DateFormatSymbols. Diese Klasse entfaltet recht interessant viele StringArrays im Speicher, die dann auch mit der Seite serialisiert wird. In Anbetracht der Eingangsdaten darf man durchaus über den Umfang überrascht sein.

## Tabelle 3

Die dritte Tabelle versucht folgendes: Wenn in der Baumstruktur gleiche Äste vorhanden sind, dann werden diese unter Berücksichtigung der Größen zusammengelegt. Das kann man an zwei Dingen gut erkennen: Bei einfach Datentypen und Wicket-Komponenten erscheinen mehrere Werte durch | getrennt innerhalb der Klammern und die ObjektID ist null. Dadurch wird der Baum kompakter und kann gerade bei ListView-Konstrukten sehr viel lesbarer werden.

Es scheint keine gute Idee zu sein, eine Instanz der Klasse SimpleDateFormat mit der Seite mitzuserialisieren. Doch welche Alternativen haben wir?

## Alternative 1

In Wicket kann man über Konverter dafür sorgen, dass eine automatische Umwandlung eines Typs in einen String oder aus einem String transparent für die restliche Anwendung durchgeführt wird. Eine einfache Methode ist das erstellen einer eigenen Label-Komponente, die einen anderen Konverter benutzt.

public class DateFormatV2Page extends WebPage
{
	public DateFormatV2Page()
	{
		add(new DateLabel("now", new DateModel()));
		add(new DateLabel("now2", new DateModel()));

		setStatelessHint(false);
	}

	static class DateLabel extends Label
	{
		public DateLabel(String id, IModel<Date> model)
		{
			super(id, model);
		}

		@Override
		public <T> IConverter<T> getConverter(Class<T> type)
		{
			return (IConverter<T>)new DateConverter()
			{
				@Override
				public DateFormat getDateFormat(Locale locale)
				{
					return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				}
			};
		}

	}
}

Das Markup bleibt unverändert. Wenn diese Seite nun serialisiert wird, ergibt sich folgendes Bild:

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.dateformat.DateFormatV2Page, id = 2, render count = 1]'
DEBUG - TypeSizeReport             - 
=======================================================================
|Type............................................................bytes|
-----------------------------------------------------------------------
|de.wicketpraxis.usecase.dateformat.DateFormatV2Page...............139|
|de.wicketpraxis.usecase.dateformat.DateFormatV2Page$DateLabel.....119|
|java.lang.Integer..................................................21|
|java.lang.String....................................................9|
|org.apache.wicket.request.mapper.parameter.PageParameters...........3|
|[Ljava.lang.Object;.................................................2|
|de.wicketpraxis.usecase.dateformat.DateModel........................2|
=======================================================================

DEBUG - TreeSizeReport             - 
=======================================================================================================
|  #|Type.........................................................................%|.sum|.local|.child|
-------------------------------------------------------------------------------------------------------
| #0|de.wicketpraxis.usecase.dateformat.DateFormatV2Page(2)....................100%|.295|...137|...158|
| #4|  [Ljava.lang.Object;......................................................49%|.146|.....2|...144|
| #5|    de.wicketpraxis.usecase.dateformat.DateFormatV2Page$DateLabel(now).....42%|.124|...112|....12|
| #9|      java.lang.Integer(=1343434906)........................................1%|...5|.....5|.....0|
|#11|      java.lang.String("now")...............................................1%|...4|.....4|.....0|
| #8|      de.wicketpraxis.usecase.dateformat.DateModel..........................0%|...1|.....1|.....0|
|#10|      java.lang.Integer(=-1)................................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.dateformat.DateFormatV2Page(2)................0%|...1|.....1|.....0|
|#12|    de.wicketpraxis.usecase.dateformat.DateFormatV2Page$DateLabel(now2).....6%|..20|.....7|....13|
|#14|      java.lang.Integer(=1343434906)........................................1%|...5|.....5|.....0|
|#16|      java.lang.String("now2")..............................................1%|...5|.....5|.....0|
|#13|      de.wicketpraxis.usecase.dateformat.DateModel..........................0%|...1|.....1|.....0|
|#15|      java.lang.Integer(=-1)................................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.dateformat.DateFormatV2Page(2)................0%|...1|.....1|.....0|
|#17|  java.lang.Integer(=1342845082)............................................1%|...5|.....5|.....0|
|#21|  org.apache.wicket.request.mapper.parameter.PageParameters.................1%|...3|.....3|.....0|
| #2|  java.lang.Integer(=1).....................................................0%|...1|.....1|.....0|
|#18|  java.lang.Integer(=-1)....................................................0%|...1|.....1|.....0|
|#19|  java.lang.Integer(=2).....................................................0%|...1|.....1|.....0|
|#22|  java.lang.Integer(=1).....................................................0%|...1|.....1|.....0|
=======================================================================================================

DEBUG - TreeSizeReport             - 
============================================================================================================
|   #|Type.............................................................................%|.sum|.local|.child|
------------------------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.dateformat.DateFormatV2Page(2)........................100%|.295|...137|...158|
|  #4|  [Ljava.lang.Object;..........................................................49%|.146|.....2|...144|
|null|    de.wicketpraxis.usecase.dateformat.DateFormatV2Page$DateLabel(now|now2)....48%|.144|...119|....25|
|null|      java.lang.Integer(=1343434906|=-1)........................................4%|..12|....12|.....0|
|null|      java.lang.String("now"|"now2")............................................3%|...9|.....9|.....0|
|null|      de.wicketpraxis.usecase.dateformat.DateModel..............................0%|...2|.....2|.....0|
|null|      de.wicketpraxis.usecase.dateformat.DateFormatV2Page(2)....................0%|...2|.....2|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1|=2)......................................3%|...9|.....9|.....0|
| #21|  org.apache.wicket.request.mapper.parameter.PageParameters.....................1%|...3|.....3|.....0|
============================================================================================================

Der größte Unterschied: viel weniger Objekte, nur noch ein drittel der Größe der vorherigen Seite. Der meiste Platz wird von der Seite und der Komponente beansprucht. Das auffällige [Ljava.lang.Object; ist einfach erklärt: Wicket verwaltet die Kindkomponenten und andere Dinge in einem ObjectArray und nicht in einer Liste. In dem Beispiel kann man auch gut erkennen, dass die Baumstruktur der Serialisierung vom der ersten und zweiten Label-Komponente gleich sind und diese für die dritte Tabelle zusammengefasst wurden.

## Alternative 2

Wenn wir schon auf Wicket-Konverter zurückgreifen, kann man das ganze noch ein wenig weiter treiben. Dazu müssen wir allerding etwas mehr Anpassungen vornehmen.

In unserer WebApplication-Klasse müssen wir folgende Methode implementieren:

	@Override
	protected IConverterLocator newConverterLocator()
	{
		ConverterLocator ret = new ConverterLocator();
		ret.set(SmallDate.class, new DateContainerConverter<SmallDate>(SmallDate.class, "dd.MM.yyyy"));
		ret.set(FullDate.class, new DateContainerConverter<FullDate>(FullDate.class, "dd.MM.yyyy HH:mm:ss"));
		return ret;
	}

Jetzt kommen noch ein paar Klassen, die notwendig sind, damit das ganze funktioniert. Die Idee dahinter ist folgende: Wicket sucht für eine Klasse den passenden Konverter über den ConverterLocator. Als Schlüssel dient der Typ. Wir benutzen einen Container-Typ von dem wir verschiedene Ableitungen erstellen (SmallDate, FullDate) und für diese Typen jeweils eigene Konverter registrieren. Doch hier erst einmal der Code:

public abstract class AbstractDateContainer
{
	private final Date value;

	public AbstractDateContainer(Date value)
	{
		this.value = value;
	}

	public Date getValue()
	{
		return value;
	}
}

public class FullDate extends AbstractDateContainer
{
	public FullDate(Date value)
	{
		super(value);
	}
}

public class SmallDate extends AbstractDateContainer
{
	public SmallDate(Date value)
	{
		super(value);
	}
}

Man sieht, am Date-Objekt, werden keine Anpassungen durch den Container vorgenommen.

public class DateContainerConverter<T extends AbstractDateContainer> extends AbstractConverter<T>
{
	private final Class<T> containerType;
	private final String pattern;
	private Constructor<T> constructor;

	public DateContainerConverter(Class<T> containerType,String pattern)
	{
		this.containerType = containerType;
		this.pattern = pattern;
		try
		{
			constructor = containerType.getConstructor(Date.class);
		}
		catch (SecurityException e)
		{
			throw new WicketRuntimeException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new WicketRuntimeException(e);
		}
	}

	

	
	/**
	 * @see org.apache.wicket.util.convert.IConverter#convertToObject(java.lang.String,Locale)
	 */
	@Override
	public T convertToObject(final String value, final Locale locale)
	{
		if ((value == null) || Strings.isEmpty(value))
		{
			return null;
		}
		else
		{
			try
			{
				return constructor.newInstance(parse(getDateFormat(locale), value, locale));
			}
			catch (IllegalArgumentException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (InstantiationException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (IllegalAccessException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (InvocationTargetException e)
			{
				throw new WicketRuntimeException(e);
			}
		}
	}

	/**
	 * @see org.apache.wicket.util.convert.IConverter#convertToString(Object, java.util.Locale)
	 */
	@Override
	public String convertToString(final T value, final Locale locale)
	{
		final Format dateFormat = getDateFormat(locale);
		if (dateFormat != null)
		{
			return dateFormat.format(value.getValue());
		}
		return value.toString();
	}

	private Format getDateFormat(Locale locale)
	{
		if (locale == null)
		{
			locale = Locale.getDefault();
		}
		return new SimpleDateFormat(this.pattern, locale);
	}

	@Override
	protected Class<T> getTargetType()
	{
		return containerType;
	}
}

Der Konverter ist so implementiert, dass er beide Konvertierungsrichtungen unterstützt. Wir benötigen jetzt für unser Beispiel allerdings noch ein Model, dass diese beiden Typen als Wert liefert.

public class DateContainerModel extends LoadableDetachableModel<AbstractDateContainer>
{
	private final boolean full;

	public DateContainerModel(boolean full)
	{
		this.full = full;
	}

	@Override
	protected AbstractDateContainer load()
	{
		return full ? new FullDate(new Date()) : new SmallDate(new Date());
	}
}

Und so wird das ganze benutzt:

public class DateFormatV3Page extends WebPage
{
	public DateFormatV3Page()
	{
		add(new Label("now", new DateContainerModel(false)));
		add(new Label("now2", new DateContainerModel(true)));

		setStatelessHint(false);
	}
}

Während bei den anderen Beispielen immer die gleiche Darstellung gewählt wurde, können wir bei diesem Beispiel an der Darstellung erkennen, ob es funktioniert hat:

	Date Format

	Now: 29.11.2012
	Now: 29.11.2012 23:42:15

Auch gespannt, welche Auswirkung das auf die Serialisierung gehabt hat?

DEBUG - KryoSerializer             - Going to serialize: '[Page class = de.wicketpraxis.usecase.dateformat.DateFormatV3Page, id = 4, render count = 1]'
DEBUG - TypeSizeReport             - 
===================================================================
|Type........................................................bytes|
-------------------------------------------------------------------
|de.wicketpraxis.usecase.dateformat.DateFormatV3Page...........139|
|org.apache.wicket.markup.html.basic.Label......................65|
|java.lang.Integer..............................................21|
|java.lang.String................................................9|
|org.apache.wicket.request.mapper.parameter.PageParameters.......3|
|java.lang.Boolean...............................................2|
|[Ljava.lang.Object;.............................................2|
|de.wicketpraxis.usecase.dateformat.DateContainerModel...........2|
===================================================================

DEBUG - TreeSizeReport             - 
============================================================================================
|  #|Type..............................................................%|.sum|.local|.child|
--------------------------------------------------------------------------------------------
| #0|de.wicketpraxis.usecase.dateformat.DateFormatV3Page(4).........100%|.243|...137|...106|
| #4|  [Ljava.lang.Object;...........................................38%|..94|.....2|....92|
| #5|    org.apache.wicket.markup.html.basic.Label(now)..............29%|..72|....59|....13|
|#10|      java.lang.Integer(=1343434906).............................2%|...5|.....5|.....0|
|#12|      java.lang.String("now")....................................1%|...4|.....4|.....0|
| #8|      de.wicketpraxis.usecase.dateformat.DateContainerModel......0%|...2|.....1|.....1|
| #9|        java.lang.Boolean........................................0%|...1|.....1|.....0|
|#11|      java.lang.Integer(=-1).....................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.dateformat.DateFormatV3Page(4).....0%|...1|.....1|.....0|
|#13|    org.apache.wicket.markup.html.basic.Label(now2)..............8%|..20|.....6|....14|
|#16|      java.lang.Integer(=1343434906).............................2%|...5|.....5|.....0|
|#18|      java.lang.String("now2")...................................2%|...5|.....5|.....0|
|#14|      de.wicketpraxis.usecase.dateformat.DateContainerModel......0%|...2|.....1|.....1|
|#15|        java.lang.Boolean........................................0%|...1|.....1|.....0|
|#17|      java.lang.Integer(=-1).....................................0%|...1|.....1|.....0|
| #0|      de.wicketpraxis.usecase.dateformat.DateFormatV3Page(4).....0%|...1|.....1|.....0|
|#19|  java.lang.Integer(=1342845082).................................2%|...5|.....5|.....0|
|#23|  org.apache.wicket.request.mapper.parameter.PageParameters......1%|...3|.....3|.....0|
| #2|  java.lang.Integer(=1)..........................................0%|...1|.....1|.....0|
|#20|  java.lang.Integer(=-1).........................................0%|...1|.....1|.....0|
|#21|  java.lang.Integer(=4)..........................................0%|...1|.....1|.....0|
|#24|  java.lang.Integer(=1)..........................................0%|...1|.....1|.....0|
============================================================================================

DEBUG - TreeSizeReport             - 
=============================================================================================
|   #|Type..............................................................%|.sum|.local|.child|
---------------------------------------------------------------------------------------------
|  #0|de.wicketpraxis.usecase.dateformat.DateFormatV3Page(4).........100%|.243|...137|...106|
|  #4|  [Ljava.lang.Object;...........................................38%|..94|.....2|....92|
|null|    org.apache.wicket.markup.html.basic.Label(now|now2).........37%|..92|....65|....27|
|null|      java.lang.Integer(=1343434906|=-1).........................4%|..12|....12|.....0|
|null|      java.lang.String("now"|"now2").............................3%|...9|.....9|.....0|
|null|      de.wicketpraxis.usecase.dateformat.DateContainerModel......1%|...4|.....2|.....2|
|null|        java.lang.Boolean........................................0%|...2|.....2|.....0|
|null|      de.wicketpraxis.usecase.dateformat.DateFormatV3Page(4).....0%|...2|.....2|.....0|
|null|  java.lang.Integer(=1|=1342845082|=-1|=4).......................3%|...9|.....9|.....0|
| #23|  org.apache.wicket.request.mapper.parameter.PageParameters......1%|...3|.....3|.....0|
=============================================================================================

Auch wenn wir wieder etwas Platz gespart haben, ist die wichtigste Botschaft hier eine etwas andere. Wir haben den Code für die Darstellung aus der Seite herausgelöst. Dieser Code wird nicht mehr mit serialisiert. Und überall, wo man den passenden Typ benutzt, ist sichergestellt, dass die Darstellung Anwendungsweit die gleiche sein wird (sofern man nicht wieder etwas dagegen unternimmt). Außerdem kann man nun andere Optimierungen vornehmen. z.B. kann man überlegen, ob man beim Erzeugen der Formater einen Instanzpool benutzt.

## Zusammenfassung

Ich hoffe, ich konnte ein wenig zeigen, welche Dinge man mit dem Tool sichtbar machen kann. Außerdem wurde hoffentlich deutlich, dass der Teufel im Detail steckt und er sich auch gern sehr gut versteckt. Wer hätte gedacht, dass die Klasse DateFormatSymbols so speicherhungrig ist. In den noch folgenden Beiträgen versuche ich wieder, die eine oder andere Überraschung ins Licht zu ziehen. Ich würde mich auch sehr über eure Erfahrungen und Anregungen freuen. Vielleicht ist ja jemand dabei, der damit ganz andere verrückte Dinge macht. Ich bin gespannt.
 
