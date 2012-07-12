/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.resources;

import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.PackageResourceReference;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "ResourceReferences")
public class ResourceRefPage extends WebPage {

	public ResourceRefPage() {
		// -> test_red_fr_CA.gif
		PackageResourceReference refCanada = new PackageResourceReference(ResourceRefPage.class, "test.gif",Locale.CANADA_FRENCH,"red",null);
		add(new Image("image", refCanada));

		// -> test.gif
		PackageResourceReference ref = new PackageResourceReference(ResourceRefPage.class, "test.gif");
		add(new Image("imageStandard", ref));
	}
}
