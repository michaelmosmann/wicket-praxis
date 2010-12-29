/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;

@TitleAnnotation(title = "Formulare - Ajax")
public class SubKapAjax extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(AjaxFormSubmitBehaviorPage.class);
		pages.add(AjaxFormValidatingBehaviorPage.class);
		pages.add(AjaxComponentUpdatingBehaviorPage.class);
		pages.add(AjaxOnChangeBehaviorPage.class);
		pages.add(AutoCompleteTextFieldPage.class);
		pages.add(AjaxEditLabelPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapForms.class;
	}

}
