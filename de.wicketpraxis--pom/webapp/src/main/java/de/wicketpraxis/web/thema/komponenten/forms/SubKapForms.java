/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;
import de.wicketpraxis.web.thema.komponenten.forms.ajax.SubKapAjax;
import de.wicketpraxis.web.thema.komponenten.forms.basics.SubKapBasics;
import de.wicketpraxis.web.thema.komponenten.forms.dynamic.SubKapDyn;
import de.wicketpraxis.web.thema.komponenten.forms.embedded.SubKapEmbedded;
import de.wicketpraxis.web.thema.komponenten.forms.feedback.SubKapFeedback;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.SubKapKomponenten;
import de.wicketpraxis.web.thema.komponenten.forms.validators.SubKapValidator;

@TitleAnnotation(title = "Formulare")
public class SubKapForms extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SubKapBasics.class);
		pages.add(SubKapKomponenten.class);
		pages.add(SubKapValidator.class);
		pages.add(SubKapAjax.class);
		pages.add(SubKapFeedback.class);
		pages.add(SubKapDyn.class);
		pages.add(SubKapEmbedded.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return KapKomponenten.class;
	}
}
