/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import java.util.Date;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class SimpleLinkPage extends WebPage {

	private Label _message;

	public SimpleLinkPage() {
		Model<String> messageModel = Model.of("Jetzt ist es " + new Date());
		_message = new Label("message", messageModel);
		add(_message);

		// Basisklasse aller Links AbstractLink

		add(new BookmarkablePageLink<AllLinkTypesPage>("bookmarkLink", SimpleLinkPage.class, new PageParameters("a=1")));

		// Zielseite ist bookmarkable
		add(new Link("noBookmarkLink") {

			@Override
			public void onClick() {
				setResponsePage(SimpleLinkPage.class, new PageParameters("b=2"));
			}
		});

		add(new Link<String>("link") {

			@Override
			public void onClick() {
				_message.setDefaultModelObject("Link geklickt (" + new Date() + ")");
			}
		});

		add(new Link<String>("linkModel", messageModel) {

			@Override
			public void onClick() {
				setModelObject("Link mit Model geklickt (" + new Date() + ")");
			}
		});
	}
}
