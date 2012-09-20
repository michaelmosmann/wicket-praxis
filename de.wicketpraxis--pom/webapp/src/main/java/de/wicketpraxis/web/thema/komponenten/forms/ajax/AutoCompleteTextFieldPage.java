/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteSettings;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class AutoCompleteTextFieldPage extends AbstractFormPage {

	IModel<List<String>> _liste = new ListModel<String>(new ArrayList<String>());

	IModel<String> _text = Model.of("");

	public AutoCompleteTextFieldPage() {

		Form form = new Form("form") {

			@Override
			protected void onSubmit() {
				_liste.getObject().add(_text.getObject());
				_text.setObject(null);
			}
		};

		AutoCompleteSettings settings = new AutoCompleteSettings();
		settings.setCssClassName("autocomplete");
		settings.setPreselect(true);

		AutoCompleteTextField<String> autoCompleteTextField = new AutoCompleteTextField<String>("Text", _text, settings) {

			@Override
			protected Iterator<String> getChoices(String input) {
				List<String> result = new ArrayList<String>();
				if ((input != null) && (input.length() > 0)) {
					for (String eintrag : _liste.getObject()) {
						// Gross-, Kleinschreibung
						if (eintrag.startsWith(input)) {
							result.add(eintrag);
						}
					}
				}
				return result.iterator();
			}
		};

		autoCompleteTextField.setRequired(true);
		form.add(autoCompleteTextField);

		add(form);

		add(new ListView<String>("liste", _liste) {

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("text", item.getModel()));
			}
		});
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(CssReferenceHeaderItem.forReference(new PackageResourceReference(AutoCompleteTextFieldPage.class, "AutoCompleteTextFieldPage.css")));
	}
}
