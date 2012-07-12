/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.dynamic;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.feedback.FormComponentCssFeedbackBorder;

public class DynFormPage extends AbstractFormPage {

	public DynFormPage() {
		final IModel<Map<String, Serializable>> model = Model.ofMap(new HashMap<String, Serializable>());
		IModel<? extends List<? extends String>> properties = Model.ofList(Arrays.asList("!Name", "!Vorname", "Straße",
				"Hausnummer"));

		Form form = new Form("form");

		form.add(new ListView<String>("inputs", properties) {

			@Override
			protected void populateItem(ListItem<String> item) {
				String id = item.getModelObject();
				boolean required = false;
				if (id.startsWith("!")) {
					id = id.substring(1);
					required = true;
				}

				FormComponentCssFeedbackBorder feedbackBorder = new FormComponentCssFeedbackBorder("border", "error");

				TextField<String> textField = new TextField<String>("input", new MapPropertyModel<String>(model, id));
				textField.setRequired(required);
				textField.setLabel(Model.of(id));

				feedbackBorder.add(new Label("id", id));
				feedbackBorder.add(textField);

				item.add(feedbackBorder);
			}
		}.setReuseItems(true));

		add(form);
	}
}
