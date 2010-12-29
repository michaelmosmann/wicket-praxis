/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;

public class SimplePanelPage extends WebPage {

	public SimplePanelPage() {
		// Reihenfolge im Template nicht wichtig
		add(new SimplePanel("p1", "Panel1"));
		add(new SimpleWithHeaderPanel("p2", "Panel2"));
		add(new SimpleWithHeaderPanel("p3", "Panel3"));
		add(new EmptyPanel("p4"));
	}
}
