/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.feedback;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;

@TitleAnnotation(title = "Formulare - Feedback")
public class SubKapFeedback extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(FormFeedbackPage.class);
		pages.add(FormComponentFeedbackPage.class);
		pages.add(FormFeedbackBorderPage.class);
		pages.add(FormFeedbackIndicatorPage.class);
		pages.add(FormComponentCssFeedbackBorderPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapForms.class;
	}

}
