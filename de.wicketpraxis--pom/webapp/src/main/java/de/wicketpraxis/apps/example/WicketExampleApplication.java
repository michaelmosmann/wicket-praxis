/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.apps.example.components.navigation.PageNavigationCallback;
import de.wicketpraxis.apps.example.pages.Seite2;
import de.wicketpraxis.apps.example.pages.Start;
import de.wicketpraxis.wicket.util.resource.MavenDevResourceStreamLocator;

public class WicketExampleApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		addComponentInstantiationListener(new SpringComponentInjector(this));

		if (DEVELOPMENT.equalsIgnoreCase(getConfigurationType())) {
			getResourceSettings().setResourceStreamLocator(new MavenDevResourceStreamLocator());
		}
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Start.class;
	}

	public List<NavigationCallbackInterface> getNavigation() {
		List<NavigationCallbackInterface> ret = new ArrayList<NavigationCallbackInterface>();
		ret.add(new PageNavigationCallback("Start", Start.class));
		ret.add(new PageNavigationCallback("Seite 2", Seite2.class));
		return ret;
	}

	public static WicketExampleApplication get() {
		return (WicketExampleApplication) Application.get();
	}
}
