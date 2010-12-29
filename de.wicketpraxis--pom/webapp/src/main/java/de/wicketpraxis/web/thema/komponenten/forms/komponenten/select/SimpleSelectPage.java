/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.select;

import java.util.Arrays;

import org.apache.wicket.extensions.markup.html.form.select.IOptionRenderer;
import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.extensions.markup.html.form.select.SelectOption;
import org.apache.wicket.extensions.markup.html.form.select.SelectOptions;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

@TitleAnnotation(title = "Select (einfach)", space = true)
public class SimpleSelectPage extends AbstractFormPage {

	public SimpleSelectPage() {
		Form<StandardTypesBean> form = new Form<StandardTypesBean>("form", new CompoundPropertyModel<StandardTypesBean>(
				new StandardTypesBean())) {

			@Override
			protected void onSubmit() {
				StandardTypesBean bean = getModelObject();
				info("Zahl: " + bean.getZahl());
				info("Text: " + bean.getText());
			}
		};

		Select select = new Select("Zahl");
		select.add(new SelectOption<Integer>("das", Model.of(1)));
		select.add(new SelectOption<Integer>("ist", Model.of(2)));
		select.add(new SelectOption<Integer>("zu", Model.of(3)));
		select.add(new SelectOption<Integer>("schwierig", Model.of(4)));

		IOptionRenderer<Integer> renderer = new IOptionRenderer<Integer>() {

			public String getDisplayValue(Integer object) {
				return "Wähle " + object.toString();
			}

			public IModel<Integer> getModel(Integer value) {
				return Model.of(value);
			}
		};
		select.add(new SelectOptions<Integer>("options", Arrays.asList(5, 6, 7, 8), renderer));
		form.add(select);
		add(form);
	}
}
