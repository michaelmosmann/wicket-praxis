/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.variations;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;

@TitleAnnotation(title = "Style, Locale und Variation")
public class SubKapVariation extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(StyleLocaleVariationPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return KapKomponenten.class;
	}

}
