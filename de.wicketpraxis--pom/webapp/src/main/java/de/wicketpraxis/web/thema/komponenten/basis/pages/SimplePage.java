/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.target.coding.BookmarkablePageRequestTargetUrlCodingStrategy;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="einfache Seite mit Links")
public class SimplePage extends WebPage
{
	public SimplePage()
	{
		initPage("Default Constructor");
	}

	public SimplePage(PageParameters pageParameters)
	{
		initPage("Constructor with PageParameter: " + pageParameters);
	}

	public SimplePage(String message)
	{
		initPage("Constructor with Parameter: " + message + " (not bookmarkable)");
	}

	protected void initPage(String message)
	{
		add(new Label("message", message));

		add(new Link("link")
			{
				@Override
				public void onClick()
				{
					setResponsePage(new SimplePage("direkt"));
				}
			});
		add(new BookmarkablePageLink<SimplePage>("linkBookmarkable",SimplePage.class));
		add(new BookmarkablePageLink<SimplePage>("linkBookmarkableParameter",SimplePage.class,new PageParameters("p=1")));
		
		/*
	
	public final <T extends Page> void mountBookmarkablePage(final String path,	final Class<T> bookmarkablePageClass)
	{
		mount(new BookmarkablePageRequestTargetUrlCodingStrategy(path, bookmarkablePageClass, null));
	}
		  
		 
		 */
	}
}
