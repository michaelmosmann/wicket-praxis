/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.Resource;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.SharedResources;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.protocol.http.WebApplication;

public class RssFeedPage extends WebPage
{
	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this)
	{
		SharedResources sharedResources = _this.getSharedResources();
		sharedResources.add("rssFeed", new RssFeedResource());
		_this.mountSharedResource("rss", new ResourceReference("rssFeed").getSharedResourceKey());
	}
	/*
	 * Code in Application
	 */
	
	public RssFeedPage()
	{
		add(new ResourceLink<Resource>("rss",new ResourceReference("rssFeed")));
	}

}
