/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;

public class PopupLinkPage extends WebPage
{
	public PopupLinkPage()
	{
		PopupSettings popupSettings = new PopupSettings(PopupSettings.RESIZABLE|PopupSettings.TOOL_BAR);
		popupSettings.setHeight(300);
		popupSettings.setWidth(300);
		popupSettings.setWindowName("Popup");
		
		BookmarkablePageLink<PopupPage> popupLink = new BookmarkablePageLink<PopupPage>("popup",PopupPage.class);
		popupLink.setPopupSettings(popupSettings);
		add(popupLink);
		
		Link popupLink2 = new Link("popup2")
		{
			@Override
			public void onClick()
			{
				setResponsePage(PopupPage.class);
			}
		};
		popupLink2.setPopupSettings(popupSettings);
		add(popupLink2);
		
		BookmarkablePageLink<PopupPage> newWindowLink = new BookmarkablePageLink<PopupPage>("newWindow",PopupPage.class);
		add(newWindowLink);
		
	}
}
