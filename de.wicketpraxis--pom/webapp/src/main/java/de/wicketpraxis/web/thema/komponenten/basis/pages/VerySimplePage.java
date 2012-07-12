/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class VerySimplePage extends WebPage {

	public VerySimplePage() {
		PageParameters pageParameters = getPageParameters();
		// dont get it wrong - pageParameters is null
		add(new Label("message", "Default Constructor with Paramter: " + pageParameters));
	}
}
