/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.markup.html.DynamicWebResource;
import org.apache.wicket.markup.html.PackageResource;

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class RssFeedResource extends DynamicWebResource {

	@Override
	protected ResourceState getResourceState() {
		return new ResourceState() {

			@Override
			public String getContentType() {
				return "text/xml";
			}

			@Override
			public byte[] getData() {
				PackageResource res = PackageResource.get(DynamicSharedResource.class, "feed.xml");
				return ResourceIOUtil.getByteArrayFrom(res);
			}

		};
	}
}
