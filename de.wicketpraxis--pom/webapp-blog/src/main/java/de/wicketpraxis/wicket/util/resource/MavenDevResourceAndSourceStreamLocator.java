/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.wicket.util.resource;

import org.apache.wicket.core.util.resource.locator.ResourceStreamLocator;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MavenDevResourceAndSourceStreamLocator extends ResourceStreamLocator {

	private static final Logger _logger = LoggerFactory.getLogger(MavenDevResourceAndSourceStreamLocator.class);

	final static String MAVEN_RESOURCE_PATH = "src/main/resources/";
	final static String MAVEN_JAVASOURCE_PATH = "src/main/java/";

	@Override
	public IResourceStream locate(final Class<?> clazz, final String path) {
		IResourceStream located = getFileSysResourceStream(MAVEN_RESOURCE_PATH, path);
		if (located == null) {
			located = getFileSysResourceStream(MAVEN_JAVASOURCE_PATH, path);
		}
		if (located != null) {
			if (_logger.isInfoEnabled())
				_logger.info("Locate: " + clazz + " in " + path + " -> " + located);
			return located;
		}
		located = super.locate(clazz, path);
		if (_logger.isInfoEnabled())
			_logger.info("Locate: " + clazz + " in " + path + " -> " + located + "(Fallback)");
		return located;
	}

	private static IResourceStream getFileSysResourceStream(String prefix, String path) {
		File f = new File(prefix + path);
		if ((f.exists()) && (f.isFile())) {
			return new FileResourceStream(f);
		}
		return null;
	}
}
