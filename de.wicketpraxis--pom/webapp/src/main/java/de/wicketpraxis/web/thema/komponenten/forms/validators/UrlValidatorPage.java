/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.UrlValidator;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class UrlValidatorPage extends AbstractFormPage
{
	public UrlValidatorPage()
	{
		Form form=new Form("form");
		
		form.add(new TextField<String>("UrlAll",Model.of("")).add(new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES)));
		form.add(new TextField<String>("UrlStandard",Model.of("")).add(new UrlValidator()));
		form.add(new TextField<String>("UrlLimit",Model.of("")).add(new UrlValidator(new String[]{"http"},UrlValidator.NO_FRAGMENTS)));
		
		add(form);
	}
}
