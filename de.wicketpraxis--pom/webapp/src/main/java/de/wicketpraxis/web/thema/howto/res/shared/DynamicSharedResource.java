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

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class DynamicSharedResource extends ByteArrayResource {

	
	public DynamicSharedResource() {
		super("image/gif");
	}
	
	@Override
	protected byte[] getData(Attributes attributes) {
		int nr = attributes.getParameters().get("Nr").toInt(-1);
		return getImage(nr);
	}
	

	public byte[] getImage(int nr) {
		String image = "testUnknown.gif";
		switch (nr) {
			case 1:
				image = "test1.gif";
				break;
			case 2:
				image = "test2.gif";
				break;
		}
		PackageResource res = new PackageResource(DynamicSharedResource.class, image,null,null,null) {};
		return ResourceIOUtil.getByteArrayFrom(res);
	}
}
