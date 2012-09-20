/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.mount;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.ClientInfo;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;

public class SessionTimeoutPage extends WebPage {

	public SessionTimeoutPage() {
		// nicht sicher, wann das zündet und welcher referer das ist..

		ServletWebRequest wicketRequest = (ServletWebRequest) getRequest();
		HttpServletRequest request = wicketRequest.getContainerRequest();
		String referer = request.getHeader("Referer");

		boolean cookies = true;
		ClientInfo clientInfo = Session.get().getClientInfo();
		if (clientInfo instanceof WebClientInfo) {
			WebClientInfo wc = (WebClientInfo) clientInfo;
			cookies = wc.getProperties().isCookiesEnabled();
		}
		add(new WebMarkupContainer("cookie-not-set").setVisible(!cookies));

		ExternalLink link = new ExternalLink("link", referer);
		link.add(new Label("url", referer));
		WebMarkupContainer text = new WebMarkupContainer("text");
		text.add(link);

		BookmarkablePageLink<? extends WebPage> start = new BookmarkablePageLink<WebPage>("start",
				Application.get().getHomePage());
		add(start);

		if ((referer != null) && (referer.indexOf("wicket:") == -1)) {
			start.setVisible(false);
		} else
			text.setVisible(false);

		add(text);
	}
}
