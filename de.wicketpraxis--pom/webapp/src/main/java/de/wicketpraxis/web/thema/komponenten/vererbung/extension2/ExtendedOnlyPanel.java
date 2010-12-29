/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension2;

public class ExtendedOnlyPanel extends AbstractBasePanel {

	public ExtendedOnlyPanel(String id) {
		super(id);
	}

	@Override
	protected String getMessage() {
		return "ExtendedOnly";
	}
}
