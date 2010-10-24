/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension2;

import org.apache.wicket.markup.html.WebPage;

public class AbstractExtensionPage extends WebPage
{
	public AbstractExtensionPage()
	{
		add(new ExtendedOnlyPanel("extended"));
	}
}
