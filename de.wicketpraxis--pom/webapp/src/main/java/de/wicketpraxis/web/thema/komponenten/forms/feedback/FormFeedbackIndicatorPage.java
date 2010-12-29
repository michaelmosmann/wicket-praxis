/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.feedback;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackIndicator;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormFeedbackIndicatorPage extends AbstractFormPage {

	public FormFeedbackIndicatorPage() {
		Form<?> f1 = new Form<Void>("form");

		TextField<String> textField = new TextField<String>("Text", new Model());
		textField.setRequired(true);

		FormComponentFeedbackIndicator feedback = new FormComponentFeedbackIndicator("feedback");
		feedback.setIndicatorFor(textField);

		TextField<String> textField2 = new TextField<String>("Text2", new Model());
		textField2.setRequired(true);

		FormComponentFeedbackIndicator feedback2 = new CustomIndicator("feedback2");
		feedback.setIndicatorFor(textField2);

		f1.add(textField);
		f1.add(feedback);
		f1.add(textField2);
		f1.add(feedback2);

		add(f1);
	}

	static class CustomIndicator extends FormComponentFeedbackIndicator {

		public CustomIndicator(String id) {
			super(id);
		}
	}
}
