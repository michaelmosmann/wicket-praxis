/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.formcomplabel;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SimpleFormComponentLabel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

@TitleAnnotation(title = "SimpleFormComponentLabel", space = true)
public class SimpleFormCompLabelPage extends AbstractFormPage {

	public SimpleFormCompLabelPage() {
		Form form = new Form("form");

		TextField<String> textField = new TextField<String>("text", new Model<String>());
		textField.setLabel(Model.of("etwas Text"));
		form.add(new SimpleFormComponentLabel("label", textField));

		form.add(textField);
		add(form);

	}
}
