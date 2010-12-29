/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.navigation.model;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.model.LoadableDetachableModel;

public class PageModel extends LoadableDetachableModel<Page> {

	Component _compontent;

	public PageModel(Component compontent) {
		_compontent = compontent;
	}

	@Override
	protected Page load() {
		return _compontent.getPage();
	}
}
