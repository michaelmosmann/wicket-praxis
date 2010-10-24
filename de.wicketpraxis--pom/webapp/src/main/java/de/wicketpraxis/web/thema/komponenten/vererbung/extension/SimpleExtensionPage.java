/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension;

import org.apache.wicket.markup.html.WebPage;

public class SimpleExtensionPage extends WebPage
{
	public SimpleExtensionPage()
	{
		add(new BasePanel("base"));
		add(new ExtendedOnlyPanel("extended"));
		add(new OverrideWithMarkupPanel("override"));
		add(new ExtendedWithMarkupPanel("withMarkup"));
	}
}
