/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension3;

import org.apache.wicket.markup.html.basic.Label;

public class BasePanelLabel extends Label {

	public static final String MESSAGE_ID = "message";

	public BasePanelLabel(String message) {
		super(MESSAGE_ID, message);
	}
}
