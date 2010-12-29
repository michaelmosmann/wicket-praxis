/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.check;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.CheckBoxBean;

@TitleAnnotation(title = "CheckBox", space = true)
public class CheckBoxPage extends AbstractFormPage {

	public CheckBoxPage() {
		Form<CheckBoxBean> form = new Form<CheckBoxBean>("form",
				new CompoundPropertyModel<CheckBoxBean>(new CheckBoxBean())) {

			@Override
			protected void onSubmit() {
				CheckBoxBean bean = getModelObject();
				info("Check: " + bean.isCheck());
				info("Liste: " + bean.getListe());
			}
		};
		form.add(new CheckBox("Check"));
		form.add(new CheckBoxMultipleChoice<String>("Liste", Arrays.asList("Handtuch", "Seife", "Stöpsel")));
		add(form);
	}
}
