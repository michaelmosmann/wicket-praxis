/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormSubmitButtonsPage extends AbstractFormPage {

	public FormSubmitButtonsPage() {
		Form form = new Form("form") {

			@Override
			protected void onSubmit() {
				info("Formular abgeschickt");
			}
		};

		form.setOutputMarkupId(true);

		form.add(new Button("button1") {

			@Override
			public void onSubmit() {
				warn("Button 1 geklickt");
			}
		});

		form.add(new Button("button2") {

			@Override
			public void onSubmit() {
				warn("Button 2 geklickt");
			}
		});

		form.add(new SubmitLink("button3"));

		add(form);

		add(new SubmitLink("button4", form));

	}
}
