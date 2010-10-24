/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.SharedResources;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.value.ValueMap;

public class SharedResourcesPage extends WebPage
{
	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this)
	{
		SharedResources sharedResources = _this.getSharedResources();
//    auch hier wird Application als Scope benutzt.. deswegen auch die ResourceReference
		sharedResources.add("dynamicSharedRes", new DynamicSharedResource());
//		_this.mountSharedResource("dynamicSharedResPath", new ResourceReference(Application.class,"dynamicSharedRes").getSharedResourceKey());
		_this.mountSharedResource("dynamicSharedResPath", new ResourceReference("dynamicSharedRes").getSharedResourceKey());
	}
	/*
	 * Code in Application
	 */
	
	public SharedResourcesPage()
	{
		add(new Image("image",new ResourceReference("dynamicSharedRes")));
		add(new Image("image1",new ResourceReference("dynamicSharedRes"),new ValueMap("Nr=1")));
		add(new Image("image2",new ResourceReference("dynamicSharedRes"),new ValueMap("Nr=2")));
	}
}
