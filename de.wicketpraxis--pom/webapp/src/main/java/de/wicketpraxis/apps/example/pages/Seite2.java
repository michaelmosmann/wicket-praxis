/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.pages;

import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import de.wicketpraxis.apps.example.WicketExampleApplication;
import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;

public class Seite2 extends AbstractNavigationPage {

	@Override
	protected IModel<List<NavigationCallbackInterface>> getNavigation() {
		return new ListModel<NavigationCallbackInterface>(WicketExampleApplication.get().getNavigation());
	}
}
