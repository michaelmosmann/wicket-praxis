/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.images;

import org.apache.wicket.extensions.markup.html.image.resource.ThumbnailImageResource;
import org.apache.wicket.markup.html.DynamicWebResource;
import org.apache.wicket.markup.html.PackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.markup.html.image.Image;

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class ImageFromDatabasePage extends WebPage
{
	public ImageFromDatabasePage()
	{
		WebResource res=new DatabaseImageResource();
		
		add(new Image("image",res));
		add(new Image("thumbnail128",new ThumbnailImageResource(res,128)));
		add(new Image("thumbnail64",new ThumbnailImageResource(res,64)));
	}
	
	static class DatabaseImageResource extends DynamicWebResource
	{
		@Override
		protected ResourceState getResourceState()
		{
			return new ResourceState()
			{
				@Override
				public String getContentType()
				{
					return "image/gif";
				}

				@Override
				public byte[] getData()
				{
					PackageResource res=PackageResource.get(ImageFromDatabasePage.class,"test.gif");
					return ResourceIOUtil.getByteArrayFrom(res);
				}
				
			};
		}
	}
}
