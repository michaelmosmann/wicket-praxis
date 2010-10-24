/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.mount;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(space=true,title="Mount Page")
@MountPath(Path="/mountedPage",Parent=BaseClass.class)
public class MountedPage extends WebPage
{
	public MountedPage()
	{
		// session expired page -> wicket nicht im pfad -> link zur seite
		// see PageMount
		
		add(new BookmarkablePageLink<SubMountedPage>("current",MountedPage.class,new PageParameters("A=1,B=2")));
		add(new Link("currentBookmark")
		{
			@Override
			public void onClick()
			{
				setResponsePage(MountedPage.class,new PageParameters("A=1,B=2"));
			}
		});
		add(new Link("currentDirect")
		{
			@Override
			public void onClick()
			{
				setResponsePage(new MountedPage());
			}
		});
		add(new BookmarkablePageLink<SubMountedPage>("sub",SubMountedPage.class,new PageParameters("A=1,B=2")));
		add(new Link("directBookmark")
		{
			@Override
			public void onClick()
			{
				setResponsePage(SubMountedPage.class,new PageParameters("A=1,B=2"));
			}
		});
		add(new Link("direct")
		{
			@Override
			public void onClick()
			{
				setResponsePage(new SubMountedPage());
			}
		});
	}
}
