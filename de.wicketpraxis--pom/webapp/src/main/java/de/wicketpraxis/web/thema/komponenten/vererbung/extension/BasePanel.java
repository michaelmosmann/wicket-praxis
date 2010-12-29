/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class BasePanel extends Panel {

	public BasePanel(String id) {
		super(id);

		add(new Label("message", getMessage()));
	}

	protected String getMessage() {
		return "Base";
	}
}
