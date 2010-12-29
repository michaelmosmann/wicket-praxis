/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.basepage.nav;

import java.util.List;

import org.apache.wicket.Page;

public abstract class AbstractNavCallback implements NavCallbackInterface {

	String _name;

	public AbstractNavCallback(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public List<NavCallbackInterface> getChilds(Page page) {
		return null;
	}

	public boolean isActive(Page page) {
		return false;
	}
}
