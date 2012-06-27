/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.blog;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.wicketpraxis.web.blog.pages.Start;
import de.wicketpraxis.web.blog.pages.questions.mergedresources.MergedResourcePage;
import de.wicketpraxis.wicket.util.resource.MavenDevResourceAndSourceStreamLocator;

public class WicketPraxisBlogApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		addComponentInstantiationListener(new SpringComponentInjector(this));

		if (DEVELOPMENT.equalsIgnoreCase(getConfigurationType())) {
			getResourceSettings().setResourceStreamLocator(new MavenDevResourceAndSourceStreamLocator());
		}

		getResourceSettings().setDisableGZipCompression(true);
		//		getResourceSettings().setAddLastModifiedTimeToResourceReferenceUrl(true);
		//		getMarkupSettings().setAutomaticLinking(true);
		
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Start.class;
	}

	public static WicketPraxisBlogApplication get() {
		return (WicketPraxisBlogApplication) Application.get();
	}
}
