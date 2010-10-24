/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.resources;

import java.util.Locale;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="ResourceReferences")
public class ResourceRefPage extends WebPage
{
	public ResourceRefPage()
	{
		// -> test_red_fr_CA.gif
		ResourceReference refCanada=new ResourceReference(ResourceRefPage.class,"test.gif");
		refCanada.setLocale(Locale.CANADA_FRENCH);
		refCanada.setStyle("red");
		add(new Image("image",refCanada));
		
		// -> test.gif
		ResourceReference ref=new ResourceReference(ResourceRefPage.class,"test.gif");
		add(new Image("imageStandard",ref));
	}
}
