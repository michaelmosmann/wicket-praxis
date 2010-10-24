/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.protocol.http.RequestUtils;

public class GetCurrentUrlPage extends WebPage
{
	public GetCurrentUrlPage(PageParameters pageParameters)
	{
		CharSequence currentUrl = urlFor(getRequestCycle().getRequestTarget());
		add(new Label("currentUrl",currentUrl.toString()));
		add(new Label("currentUrlAbs",RequestUtils.toAbsolutePath(currentUrl.toString())));
		
		CharSequence customUrl = urlFor(GetCurrentUrlPage.class,new PageParameters("a=1,b=2"));
		add(new Label("customUrl",customUrl.toString()));
		
		add(new BookmarkablePageLink<GetCurrentUrlPage>("link",GetCurrentUrlPage.class,new PageParameters("c=3")));
	}
}
