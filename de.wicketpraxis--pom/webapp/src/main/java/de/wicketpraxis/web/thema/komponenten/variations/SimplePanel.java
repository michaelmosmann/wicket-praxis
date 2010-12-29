/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.variations;

import java.util.Locale;

import org.apache.wicket.markup.html.panel.Panel;

public class SimplePanel extends Panel {

	String _variation;
	Locale _locale;

	public SimplePanel(String id) {
		super(id);
	}

	public SimplePanel(String id, String variation) {
		this(id);
		_variation = variation;
	}

	public SimplePanel setLocale(Locale locale) {
		_locale = locale;
		return this;
	}

	@Override
	public String getVariation() {
		return _variation;
	}

	@Override
	public Locale getLocale() {
		if (_locale != null)
			return _locale;
		return super.getLocale();
	}
}
