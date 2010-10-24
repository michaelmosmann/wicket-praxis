/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class SimpleWebMarkupContainerPage extends WebPage
{
	public SimpleWebMarkupContainerPage()
	{
		add(new WebMarkupContainer("p1").add(new Label("message","p1")));
		add(new WebMarkupContainer("p2").add(new Label("message","p2")));
	}
}
