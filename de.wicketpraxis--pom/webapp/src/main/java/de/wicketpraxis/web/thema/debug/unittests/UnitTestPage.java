/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug.unittests;

import org.apache.wicket.markup.html.WebPage;

public class UnitTestPage extends WebPage {

	public UnitTestPage() {
		add(new CustomPanel("mypanel"));
	}
}
