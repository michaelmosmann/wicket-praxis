/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.mount;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

@MountPath(Path="/sub",Parent=MountedPage.class)
public class SubMountedPage extends WebPage
{
	public SubMountedPage()
	{
		add(new Link("link")
		{
			@Override
			public void onClick()
			{
				setResponsePage(new SubMountedPage());
			}
		});
	}
}
