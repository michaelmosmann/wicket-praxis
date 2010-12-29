/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LieblingsfarbenBean implements Serializable {

	List<String> _lieblingsfarben = new ArrayList<String>();

	public List<String> getLieblingsfarben() {
		return _lieblingsfarben;
	}

	public void setLieblingsfarben(List<String> lieblingsfarben) {
		_lieblingsfarben = lieblingsfarben;
	}
}
