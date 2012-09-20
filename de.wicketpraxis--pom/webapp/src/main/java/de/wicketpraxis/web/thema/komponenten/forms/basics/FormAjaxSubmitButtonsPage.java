/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxFallbackButton;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormAjaxSubmitButtonsPage extends AbstractFormPage {

	public FormAjaxSubmitButtonsPage() {
		Form form = new Form("form") {

			@Override
			protected void onSubmit() {
				info("Formular abgeschickt");
			}
		};

		form.setOutputMarkupId(true);

		// submit auf alle Fälle
		// onSubmit auch
		form.add(new AjaxFallbackButton("button1", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				warn("Button 1 geklickt");
				if (target != null) {
					target.add(form);
					target.add(getFeedbackPanel());
				}
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub
				
			}
		});

		// submit auf alle Fälle
		// onSubmit nicht
		form.add(new AjaxButton("button2", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				warn("Button 2 geklickt");
				target.add(form);
				target.add(getFeedbackPanel());
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub
				
			}
		});

		add(form);

		// geht nur mit Javascript
		add(new AjaxSubmitLink("button3", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				warn("Button 3 geklickt");
				target.add(form);
				target.add(getFeedbackPanel());
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
