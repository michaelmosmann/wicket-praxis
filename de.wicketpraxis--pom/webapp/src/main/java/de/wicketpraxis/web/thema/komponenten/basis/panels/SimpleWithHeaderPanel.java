/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.PackageResourceReference;

public class SimpleWithHeaderPanel extends SimplePanel {

	public SimpleWithHeaderPanel(String id, String message) {
		super(id, message);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.renderCSSReference(new PackageResourceReference(getClass(), "styles/standard.css"));
	}
}
