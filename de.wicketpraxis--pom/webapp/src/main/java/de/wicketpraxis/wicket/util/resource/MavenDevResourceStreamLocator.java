/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.wicket.util.resource;

import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.locator.ResourceStreamLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenDevResourceStreamLocator extends ResourceStreamLocator {

	private static final Logger _logger = LoggerFactory.getLogger(MavenDevResourceStreamLocator.class);

	String _prefix = "src/main/resources/";

	@Override
	public IResourceStream locate(Class<?> clazz, String path) {
		IResourceStream located = getFileSysResourceStream(path);
		if (located != null)
			return located;
		return super.locate(clazz, path);
	}

	private IResourceStream getFileSysResourceStream(String path) {
		File f = new File(_prefix + path);
		if ((f.exists()) && (f.isFile())) {
			_logger.info("Read File: {}", f);
			return new FileResourceStream(f);
		}
		//		else _logger.info("Missing File: {}",f);

		return null;
	}
}
