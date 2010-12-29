/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;

@TitleAnnotation(title = "Formulare - Validatoren")
public class SubKapValidator extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(StringValidatorPage.class);
		pages.add(RangeMinMaxValidatorPage.class);
		pages.add(EMailValidatorPage.class);
		pages.add(UrlValidatorPage.class);
		pages.add(CustomValidatorPage.class);
		pages.add(FormValidatorPage.class);
		pages.add(CustomFormValidatorPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapForms.class;
	}

}
