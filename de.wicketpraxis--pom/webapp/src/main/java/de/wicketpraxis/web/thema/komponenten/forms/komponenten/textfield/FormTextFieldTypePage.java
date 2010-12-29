/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormTextFieldTypePage extends AbstractFormPage {

	public FormTextFieldTypePage() {
		final Model<String> modelText = new Model<String>();
		final Model<Integer> modelNumber = new Model<Integer>();

		Form form = new Form("form") {

			@Override
			protected void onSubmit() {
				Object valueText = modelText.getObject();
				Object valueNumber = modelNumber.getObject();
				info("TextType: " + valueText.getClass());
				info("NumberType: " + valueNumber.getClass()); // -> java.lang.String
			}
		};
		TextField<String> textField = new TextField<String>("Text", modelText);
		textField.setRequired(true);
		form.add(textField);

		TextField<Integer> numberField = new TextField<Integer>("Zahl", modelNumber);
		numberField.setRequired(true);
		form.add(numberField);

		form.add(new Button("submit"));
		add(form);
	}
}
