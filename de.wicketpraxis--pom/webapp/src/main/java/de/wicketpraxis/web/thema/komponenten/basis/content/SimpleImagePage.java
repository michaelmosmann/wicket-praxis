/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.util.Locale;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Images")
public class SimpleImagePage extends WebPage {

	public SimpleImagePage() {
		add(new Label("locale", Model.of(getLocale())));
		add(new Label("style", getStyle()));

		// test1.gif vorhanden
		// -> src=".../test1.gif"
		add(new Image("image1", "test1.gif"));
		//		add(new Image("image1Model",Model.of("test1.gif")));

		// test2.gif und test2_de_DE.gif vorhanden
		// -> src=".../test2_de_DE.gif"
		add(new Image("image2", "test2.gif"));
		//		add(new Image("image2Model",Model.of("test2.gif")));
		add(new Image("image2ResourceRef", new ResourceReference(SimpleImagePage.class, "test2.gif", getLocale(),
				getStyle())));

		// -> src=".../test2.gif"
		add(new Image("image2ResourceRefOhne", new ResourceReference(SimpleImagePage.class, "test2.gif")));
		add(new Image("image2ResourceRefMit", new ResourceReference(SimpleImagePage.class, "test2.gif", null, null)));

		// test3.gif vorhanden
		// -> src=".../test3.gif"
		add(new Image("image3", "test3.gif"));
		//		add(new Image("image3Model",Model.of("test3.gif")));
		//		add(new Image("image3ResourceRef",new ResourceReference(SimpleImagePage.class,"test3.gif",getLocale(),getStyle())));
		add(new Image("image3rot", "test3.gif") {

			@Override
			public String getVariation() {
				return "rot";
			}
		});

		// test4.gif nicht vorhanden
		// -> src=".../test4_de_DE.gif"
		add(new Image("image4", "test4.gif"));
		//		add(new Image("image4Model",Model.of("test4.gif")));
		//		add(new Image("image4ResourceRef",new ResourceReference(SimpleImagePage.class,"test4.gif",getLocale(),getStyle())));
	}
}
