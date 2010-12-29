/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.CalcBean;

public class CustomFormValidatorPage extends AbstractFormPage {

	public CustomFormValidatorPage() {
		Form<CalcBean> form = new Form<CalcBean>("form", new CompoundPropertyModel<CalcBean>(new CalcBean())) {

			@Override
			protected void onSubmit() {
				info(getModelObject().toString());
			}
		};

		final TextField<Integer> a = new TextField<Integer>("A");
		final TextField<Integer> b = new TextField<Integer>("B");
		final TextField<Integer> summe = new TextField<Integer>("Summe");
		a.setRequired(true);
		b.setRequired(true);
		summe.setRequired(true);
		form.add(a);
		form.add(b);
		form.add(summe);

		form.add(new AbstractFormValidator() {

			public FormComponent<?>[] getDependentFormComponents() {
				return new FormComponent<?>[] {a, b, summe};
			}

			public void validate(Form<?> form) {
				int aInput = a.getConvertedInput();
				int bInput = b.getConvertedInput();
				int summeInput = summe.getConvertedInput();
				if ((aInput + bInput) != summeInput) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("a", aInput);
					param.put("b", bInput);
					param.put("summe", summeInput);
					param.put("result", aInput + bInput);
					error(summe, "summe", param);
				}
			}
		});

		add(form);
	}
}
