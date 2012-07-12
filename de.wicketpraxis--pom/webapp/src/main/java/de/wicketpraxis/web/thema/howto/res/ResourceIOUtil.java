/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.res;

import java.io.IOException;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.request.resource.PackageResource;
import org.apache.wicket.util.io.IOUtils;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;

public class ResourceIOUtil {

	public static byte[] getByteArrayFrom(PackageResource resource) {
		try {
			return IOUtils.toByteArray(resource.getCacheableResourceStream().getInputStream());
		} catch (IOException e) {
			throw new WicketRuntimeException(e);
		} catch (ResourceStreamNotFoundException e) {
			throw new WicketRuntimeException(e);
		}
	}

	//	public static byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException
	//	{
	//		ByteArrayOutputStream out = new ByteArrayOutputStream();
	//		byte[] buf = new byte[512];
	//		int read;
	//		do
	//		{
	//			read = inputStream.read(buf);
	//			if (read != -1)
	//			{
	//				out.write(buf, 0, read);
	//			}
	//		}
	//		while (read != -1);
	//		return out.toByteArray();
	//	}

}
