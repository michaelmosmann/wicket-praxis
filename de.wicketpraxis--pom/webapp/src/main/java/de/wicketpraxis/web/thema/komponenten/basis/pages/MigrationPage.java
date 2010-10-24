/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.target.basic.RedirectRequestTarget;

public class MigrationPage extends WebPage
{
	public MigrationPage(PageParameters pageParameters)
	{
		getRequestCycle().setRequestTarget(new RedirectRequestTarget("/alteAnwendung?Nr="+pageParameters.getString("Nr")));
	}
	
	public static AbstractLink getLink(String id,int nr)
	{
		return new BookmarkablePageLink<MigrationPage>(id,MigrationPage.class, new PageParameters("Nr="+nr));
	}
	
}
