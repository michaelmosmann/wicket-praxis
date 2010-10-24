/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.shared;

import org.apache.wicket.markup.html.DynamicWebResource;
import org.apache.wicket.markup.html.PackageResource;
import org.apache.wicket.util.value.ValueMap;

import de.wicketpraxis.web.thema.howto.res.ResourceIOUtil;

public class DynamicSharedResource extends DynamicWebResource
{
	@Override
	protected ResourceState getResourceState()
	{
		ValueMap parameters = getParameters();
		final int nr = parameters.getInt("Nr",-1);
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
				return getImage(nr);
			}
			
		};
	}
	
	public byte[] getImage(int nr)
	{
		String image = "testUnknown.gif";
		switch (nr)
		{
			case 1: image="test1.gif";break;
			case 2: image="test2.gif";break;
		}
		PackageResource res = PackageResource.get(DynamicSharedResource.class, image);
		return ResourceIOUtil.getByteArrayFrom(res);
	}
}
