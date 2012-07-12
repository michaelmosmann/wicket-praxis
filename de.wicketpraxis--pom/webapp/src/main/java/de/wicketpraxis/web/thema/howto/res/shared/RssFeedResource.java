/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class RssFeedResource extends ByteArrayResource {

	
	public RssFeedResource() {
		super("text/xml");
	}
	
	@Override
	protected byte[] getData(Attributes attributes) {
		PackageResource res = new PackageResource(DynamicSharedResource.class, "feed.xml",null,null,null) {};
		return ResourceIOUtil.getByteArrayFrom(res);
	}
}
