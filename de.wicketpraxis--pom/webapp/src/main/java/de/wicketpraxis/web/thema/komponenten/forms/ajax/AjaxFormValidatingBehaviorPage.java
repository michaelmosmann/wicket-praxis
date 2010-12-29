/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import java.io.Serializable;
import java.text.MessageFormat;

import org.apache.wicket.ajax.form.AjaxFormValidatingBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class AjaxFormValidatingBehaviorPage extends AbstractFormPage {

	public AjaxFormValidatingBehaviorPage() {
		Form<StandardTypesBean> form = new Form<StandardTypesBean>("form", new CompoundPropertyModel<StandardTypesBean>(
				new StandardTypesBean())) {

			@Override
			protected void onSubmit() {
				info("Text: " + getModelObject().getText());
			}
		};
		//		form.setOutputMarkupId(true);

		// ist von AjaxFormSubmitBehavior abgeleitet und aktualisiert alle FeedbackPanels
		AjaxFormValidatingBehavior ajaxBehavior = new AjaxFormValidatingBehavior(form, "onBlur");
		form.add(new TextField<String>("Text").setRequired(true).add(ajaxBehavior));
		add(form);
	}
}
