/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;

public class HeaderReferencesPage extends WebPage {

	public HeaderReferencesPage() {
		add(CSSPackageResource.getHeaderContribution(HeaderReferencesPage.class, "styles/standard.css"));
		add(CSSPackageResource.getHeaderContribution(new ResourceReference(HeaderReferencesPage.class, "styles/locale.css",
				getLocale(), getStyle())));

		add(JavascriptPackageResource.getHeaderContribution(HeaderReferencesPage.class, "js/test.js"));

		add(new HeaderContributor(new IHeaderContributor() {

			public void renderHead(IHeaderResponse response) {
				response.renderString("<!-- mein Beitrag -->");
			}
		}));
	}
}
