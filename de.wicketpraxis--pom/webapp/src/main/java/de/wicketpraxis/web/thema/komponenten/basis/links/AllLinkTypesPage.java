/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Alle Link Typen")
public class AllLinkTypesPage extends WebPage {

	private Label _message;

	public AllLinkTypesPage() {
		_message = new Label("message", "Jetzt ist es " + new Date());
		add(_message);

		add(new BookmarkablePageLink<AllLinkTypesPage>("bookmarkLink", AllLinkTypesPage.class));
		add(new Link("link") {

			@Override
			public void onClick() {
				setResponsePage(AllLinkTypesPage.class);
			}
		});
		add(new Link("linkAction") {

			@Override
			public void onClick() {
				_message.setDefaultModelObject("Link geklickt (" + new Date() + ")");
			}
		});
		add(new ExternalLink("external", "http://www.wicket-praxis.de"));
		add(new ExternalLink("mail", "mailto:michael@mosmann.de"));

		BookmarkablePageLink<PopupPage> popupLink = new BookmarkablePageLink<PopupPage>("popup", PopupPage.class);
		PopupSettings popupSettings = new PopupSettings(PopupSettings.RESIZABLE | PopupSettings.TOOL_BAR);
		popupSettings.setHeight(300);
		popupSettings.setWidth(300);
		popupSettings.setWindowName("Popup");
		popupLink.setPopupSettings(popupSettings);
		add(popupLink);

		add(new AjaxFallbackLink("ajax") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				_message.setDefaultModelObject("Ajax Link geklickt (" + new Date() + ")");
				if (target != null) {
					target.add(_message);
				}
			}
		});
		add(new IndicatingAjaxLink("ajax2") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				_message.setDefaultModelObject("Ajax Link geklickt (" + new Date() + ")");
				if (target != null) {
					target.add(_message);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		_message.setOutputMarkupId(true);
	}
}
