/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.RangeValidator;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class RangeMinMaxValidatorPage extends AbstractFormPage {

	public RangeMinMaxValidatorPage() {
		Form<StandardTypesBean> form = new Form<StandardTypesBean>("form", new CompoundPropertyModel<StandardTypesBean>(
				new StandardTypesBean()));

		form.add(new TextField<Integer>("Zahl").add(RangeValidator.minimum(12)));
		form.add(new TextField<Double>("Kommazahl").add(new RangeValidator<Double>(Math.PI, 42d)));
		form.add(new TextField<String>("Text").add(RangeValidator.maximum("EDCBA")));

		form.add(new TextField<Date>("Datum").add(RangeValidator.maximum(new Date())));
		//		form.add(new TextField<Date>("Datum").add(DateValidator.maximum(new Date())));

		add(form);
	}

}
