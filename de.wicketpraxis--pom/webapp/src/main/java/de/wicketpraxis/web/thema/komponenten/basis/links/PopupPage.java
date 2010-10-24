/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PopupCloseLink;

public class PopupPage extends WebPage
{
	public PopupPage()
	{
		add(new PopupCloseLink("close"));
	}
}
