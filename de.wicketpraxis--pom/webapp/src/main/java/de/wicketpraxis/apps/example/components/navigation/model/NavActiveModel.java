/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.navigation.model;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.web.model.Cascading2LoadableDetachableModel;

public class NavActiveModel extends Cascading2LoadableDetachableModel<Boolean, NavigationCallbackInterface, Page> {

	public NavActiveModel(IModel<? extends NavigationCallbackInterface> parent, IModel<Page> pageModel) {
		super(parent, pageModel);
	}

	@Override
	protected Boolean load(NavigationCallbackInterface p1, Page p2) {
		return p1.isActive(p2);
	}
}
