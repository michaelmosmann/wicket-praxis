/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import java.io.Serializable;
import java.text.MessageFormat;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class AjaxOnChangeBehaviorPage extends AbstractFormPage
{
	public AjaxOnChangeBehaviorPage()
	{
		final Form<StandardTypesBean> form=new Form<StandardTypesBean>("form",new CompoundPropertyModel<StandardTypesBean>(new StandardTypesBean()))
		{
			@Override
			protected void onSubmit()
			{
				info("Text: "+getModelObject().getText());
			}
		};
		form.setOutputMarkupId(true);
		
		final TextField<String> textField = new TextField<String>("Text");
		OnChangeAjaxBehavior ajaxBehavior=new OnChangeAjaxBehavior()
		{
			@Override
			protected void onUpdate(AjaxRequestTarget target)
			{
				info("Ajax.Update: Text: "+form.getModelObject().getText()+" Input: "+textField.getConvertedInput());
				updateFeedbackPanel(target);
			}
			
			@Override
			protected boolean getUpdateModel()
			{
				return false;
			}
		};
		form.add(textField.setRequired(true).add(ajaxBehavior));
		add(form);
	}
}
