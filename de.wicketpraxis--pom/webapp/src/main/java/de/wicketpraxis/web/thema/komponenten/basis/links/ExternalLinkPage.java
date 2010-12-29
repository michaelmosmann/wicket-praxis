/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;

public class ExternalLinkPage extends WebPage {

	public ExternalLinkPage() {
		add(new ExternalLink("external", "http://www.wicket-praxis.de"));
		add(new ExternalLink("mail", "mailto:michael@mosmann.de"));
	}
}
