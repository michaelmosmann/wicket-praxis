/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.ajax.SubKapAjax;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;
import de.wicketpraxis.web.thema.komponenten.behaviors.SubKapBehaviors;
import de.wicketpraxis.web.thema.komponenten.converter.SubKapConverter;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;
import de.wicketpraxis.web.thema.komponenten.komposition.SubKapKomposition;
import de.wicketpraxis.web.thema.komponenten.tree.SubKapTree;
import de.wicketpraxis.web.thema.komponenten.variations.SubKapVariation;
import de.wicketpraxis.web.thema.komponenten.vererbung.SubKapVererbung;
import de.wicketpraxis.web.thema.komponenten.visibility.SubKapVisible;

@TitleAnnotation(title = "Komponenten")
public class KapKomponenten extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SubKapVariation.class);
		pages.add(SubKapVisible.class);
		pages.add(SubKapTree.class);
		pages.add(SubKapVererbung.class);
		pages.add(SubKapAjax.class);
		pages.add(SubKapConverter.class);
		pages.add(SubKapBasiskomponenten.class);
		pages.add(SubKapBehaviors.class);
		pages.add(SubKapForms.class);
		pages.add(SubKapKomposition.class);
	}

	@Override
	protected String getTitle() {
		return "Komponenten";
	}

}
