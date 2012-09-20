/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.protocol.http.RequestUtils;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.wicketpraxis.wicketext.RequestUtilsExt;

public class GetCurrentUrlPage extends WebPage {

	public GetCurrentUrlPage(PageParameters pageParameters) {
		CharSequence currentUrl = urlFor(getRequestCycle().getActiveRequestHandler());
		add(new Label("currentUrl", currentUrl.toString()));
		add(new Label("currentUrlAbs", RequestUtilsExt.toAbsolutePath(currentUrl.toString())));

		CharSequence customUrl = urlFor(GetCurrentUrlPage.class, new PageParameters().add("a",1).add("b",2));
		add(new Label("customUrl", customUrl.toString()));

		add(new BookmarkablePageLink<GetCurrentUrlPage>("link", GetCurrentUrlPage.class, new PageParameters().add("c","3")));
	}
}
