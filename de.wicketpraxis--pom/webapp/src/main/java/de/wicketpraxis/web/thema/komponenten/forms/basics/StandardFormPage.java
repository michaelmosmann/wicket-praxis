/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import org.apache.wicket.markup.html.form.Form;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class StandardFormPage extends AbstractFormPage {

	public StandardFormPage() {
		add(new Form("form") {

			@Override
			protected void onSubmit() {
				info("Formular abgeschickt");
			}
		});

	}
}
