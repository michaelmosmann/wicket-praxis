/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

public class HeaderReferencesPage extends WebPage {

	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		response.renderCSSReference(new PackageResourceReference(HeaderReferencesPage.class, "styles/standard.css"));
		response.renderCSSReference(new PackageResourceReference(HeaderReferencesPage.class, "styles/locale.css",
				getLocale(), getStyle(),getVariation()));

		response.renderJavaScriptReference(new PackageResourceReference(HeaderReferencesPage.class, "js/test.js"));

		response.renderString("<!-- mein Beitrag -->");
	}
}
