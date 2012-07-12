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
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.value.ValueMap;

public class SharedResourcesPage extends WebPage {

	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this) {
		SharedResources sharedResources = _this.getSharedResources();
		//    auch hier wird Application als Scope benutzt.. deswegen auch die ResourceReference
		sharedResources.add("dynamicSharedRes", new DynamicSharedResource());
		//		_this.mountSharedResource("dynamicSharedResPath", new ResourceReference(Application.class,"dynamicSharedRes").getSharedResourceKey());
		_this.mountResource("dynamicSharedResPath", getResourceReference(sharedResources, "dynamicSharedRes"));
	}

	private static ResourceReference getResourceReference(SharedResources sharedResources, String name) {
		return sharedResources.get(Application.class, name, null, null, null, true);
	}

	/*
	 * Code in Application
	 */

	public SharedResourcesPage() {
		SharedResources sharedResources = Application.get().getSharedResources();
		add(new Image("image", getResourceReference(sharedResources, "dynamicSharedRes")));
		add(new Image("image1", getResourceReference(sharedResources, "dynamicSharedRes"), new PageParameters().set("Nr",1)));
		add(new Image("image2", getResourceReference(sharedResources, "dynamicSharedRes"), new PageParameters().set("Nr",2)));
	}
}
