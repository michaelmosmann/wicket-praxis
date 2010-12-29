/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class AjaxComponentUpdatingBehaviorPage extends AbstractFormPage {

	public AjaxComponentUpdatingBehaviorPage() {
		final Form<StandardTypesBean> form = new Form<StandardTypesBean>("form",
				new CompoundPropertyModel<StandardTypesBean>(new StandardTypesBean())) {

			@Override
			protected void onSubmit() {
				StandardTypesBean bean = getModelObject();
				info("Text: " + bean.getText() + ", Text2: " + bean.getText2());
			}

			@Override
			protected void onError() {
				StandardTypesBean bean = getModelObject();
				warn("Text: " + bean.getText() + ", Text2: " + bean.getText2());
			}
		};
		form.setOutputMarkupId(true);

		final TextField<String> textField = new TextField<String>("Text");

		AjaxFormComponentUpdatingBehavior ajaxBehavior = new AjaxFormComponentUpdatingBehavior("onBlur") {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				StandardTypesBean bean = form.getModelObject();
				info("Ajax.Update: Text: " + bean.getText() + ", Text2: " + bean.getText2() + " Input: "
						+ textField.getConvertedInput());
				updateFeedbackPanel(target);
			}

			@Override
			protected void onError(AjaxRequestTarget target, RuntimeException e) {
				super.onError(target, e);
				StandardTypesBean bean = form.getModelObject();
				error("Ajax.Error: Text: " + bean.getText() + ", Text2: " + bean.getText2() + " Input: "
						+ textField.getConvertedInput());
				updateFeedbackPanel(target);
			}

			//			@Override
			//			protected boolean getUpdateModel()
			//			{
			//				return false;
			//			}
		};

		textField.setRequired(true).add(ajaxBehavior);

		TextField<String> textField2 = new TextField<String>("Text2");
		textField2.setRequired(true);
		form.add(textField2);
		form.add(textField);
		add(form);
	}
}
