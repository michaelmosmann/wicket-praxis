/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.select;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.util.CollectionModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.LieblingsfarbenBean;

public class PalettePage extends AbstractFormPage {

	public PalettePage() {
		Form<LieblingsfarbenBean> form = new Form<LieblingsfarbenBean>("form",
				new CompoundPropertyModel<LieblingsfarbenBean>(new LieblingsfarbenBean())) {

			@Override
			protected void onSubmit() {
				LieblingsfarbenBean bean = getModelObject();
				info("Lieblingsfarben: " + bean.getLieblingsfarben());
			}
		};

		CollectionModel<String> farben = new CollectionModel<String>(Arrays.asList("Rot", "Grün", "Gelb", "Ocker",
				"Schwarz"));
		IChoiceRenderer<String> renderer = new IChoiceRenderer<String>() {

			public Object getDisplayValue(String object) {
				return object;
			}

			public String getIdValue(String object, int index) {
				return object;
			}
		};
		form.add(new Palette<String>("Lieblingsfarben", farben, renderer, 10, true));

		add(form);
	}

}
