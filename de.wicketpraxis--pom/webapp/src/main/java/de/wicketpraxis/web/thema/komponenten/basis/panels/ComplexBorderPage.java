/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;

public class ComplexBorderPage extends WebPage {

	public ComplexBorderPage() {
		ComplexBorder complexBorder = new ComplexBorder("border", "It's a border.");
		complexBorder.add(new Label("message", "in a border"));
		add(complexBorder);

		ComplexBorder complexBorder2 = new ComplexBorder("border2", "It's an other border.");
		complexBorder2.setTransparentResolver(true);
		add(complexBorder2);

		add(new Label("message", "again in a border?"));
	}

	static class ComplexBorder extends Border {

		public ComplexBorder(String id, String message) {
			super(id);

			add(new Label("border_message", message));
		}
	}
}
