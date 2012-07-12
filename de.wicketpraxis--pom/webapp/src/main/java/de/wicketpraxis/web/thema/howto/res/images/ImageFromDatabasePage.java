/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.res.images;

import org.apache.wicket.Application;
import org.apache.wicket.extensions.markup.html.image.resource.ThumbnailImageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.PackageResource;

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class ImageFromDatabasePage extends WebPage {

	public ImageFromDatabasePage() {
		IResource res = new DatabaseImageResource();

		add(new Image("image", res));
		add(new Image("thumbnail128", new ThumbnailImageResource(res, 128)));
		add(new Image("thumbnail64", new ThumbnailImageResource(res, 64)));
	}

	static class DatabaseImageResource extends ByteArrayResource {

		
		public DatabaseImageResource() {
			super("image/gif");
		}
		
		@Override
		protected byte[] getData(Attributes attributes) {
			PackageResource res = new PackageResource(ImageFromDatabasePage.class, "test.gif",null,null,null) {
				
			};
			return ResourceIOUtil.getByteArrayFrom(res);
		}
	}
}
