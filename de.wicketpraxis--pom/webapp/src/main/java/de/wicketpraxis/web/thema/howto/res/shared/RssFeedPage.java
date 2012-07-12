/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.Application;
import org.apache.wicket.SharedResources;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

public class RssFeedPage extends WebPage {

	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this) {
		SharedResources sharedResources = _this.getSharedResources();
		RssFeedResource resource = new RssFeedResource();
		sharedResources.add("rssFeed", resource);
		_this.mountResource("rss", getResourceReference(sharedResources,"rssFeed"));
	}

	private static ResourceReference getResourceReference(SharedResources sharedResources, String name) {
		return sharedResources.get(Application.class, name, null, null, null, true);
	}

	/*
	 * Code in Application
	 */

	public RssFeedPage() {
		add(new ResourceLink<IResource>("rss", getResourceReference(Application.get().getSharedResources(),"rssFeed")));
	}

}
