/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.pages.start;

import org.apache.wicket.Page;

import de.wicketpraxis.apps.example.pages.Start;

public abstract class AbstractSubNav extends AbstractStartNav {

	String _name;

	public AbstractSubNav(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public boolean isActive(Page page) {
		if (page instanceof Start) {
			return ((Start) page).isActive(this);
		}
		return false;
	}
}
