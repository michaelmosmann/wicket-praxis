/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.embedded;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class FormFormPage extends AbstractFormPage
{
	private StandardTypesBean _bean;
	private StandardTypesBean _subBean;

	public FormFormPage()
	{
		_bean = new StandardTypesBean();
		_subBean=new StandardTypesBean();
		
		Form<StandardTypesBean> form=new Form<StandardTypesBean>("form",new CompoundPropertyModel<StandardTypesBean>(_bean))
		{
			@Override
			protected void onSubmit()
			{
				showInfo("Main");
			}
		};
		
		form.add(new TextField<String>("Text"));
		
		Form<StandardTypesBean> subForm=new Form<StandardTypesBean>("sub",new CompoundPropertyModel<StandardTypesBean>(_subBean))
		{
			@Override
			protected void onSubmit()
			{
				showInfo("Sub");
			}
		};
		
		subForm.add(new TextField<String>("Text"));
		
		form.add(subForm);
		
		add(form);
	}

	protected void showInfo(String source)
	{
		info("Beans: "+_bean.getText()+", "+_subBean.getText()+", Form: "+source);
	}
}
