/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.MaximumValidator;
import org.apache.wicket.validation.validator.StringValidator;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class StringValidatorPage extends AbstractFormPage {

	public StringValidatorPage() {
		Form form = new Form("form");

		// ersetzt nicht .setRequired(true)
		form.add(new TextField<String>("Len4", Model.of("")).add(StringValidator.exactLength(4)));
		form.add(new TextField<String>("Len24", Model.of("")).add(StringValidator.lengthBetween(2, 4)));
		form.add(new TextField<String>("Max8", Model.of("")).add(StringValidator.maximumLength(8)));
		form.add(new TextField<String>("Min2", Model.of("")).add(StringValidator.minimumLength(2)));

		add(form);
	}
}
