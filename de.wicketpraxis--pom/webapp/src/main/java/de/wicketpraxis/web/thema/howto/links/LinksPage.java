/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.links;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.RequestUtils;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import de.wicketpraxis.wicketext.RequestUtilsExt;

public class LinksPage extends WebPage {

	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this) {
//		_this.mountSharedResource("linksPageResource",
//				new ResourceReference(LinksPage.class, "resource.txt").getSharedResourceKey());
		_this.mountResource("linksPageResource",
				new PackageResourceReference(LinksPage.class, "resource.txt"));
		_this.mountPage("linksPage", LinksPage.class);
	}

	/*
	 * Code in Application
	 */

	public LinksPage() {
		String resourceUrl = urlFor(new PackageResourceReference(LinksPage.class, "resource.txt"), new PageParameters()).toString();
		String pageUrl = urlFor(LinksPage.class, new PageParameters("P=1")).toString();

		add(new Label("resourceUrl", resourceUrl));
		add(new Label("pageUrl", pageUrl));

		add(new Label("absResourceUrl", RequestUtilsExt.toAbsolutePath(resourceUrl)));
		add(new Label("absPageUrl", RequestUtilsExt.toAbsolutePath(pageUrl)));
	}
}
