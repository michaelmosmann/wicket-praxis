/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield;

import java.util.Date;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

public class TextFieldsPage extends AbstractFormPage
{
	public TextFieldsPage()
	{
		StandardTypesBean bean = new StandardTypesBean();
		bean.setDatum(new Date());
		
		// Model am Formular
		Form<StandardTypesBean> form=new Form<StandardTypesBean>("form",new CompoundPropertyModel<StandardTypesBean>(bean))
		{
			@Override
			protected void onSubmit()
			{
				StandardTypesBean bean = getModelObject();
				info("Text: "+bean.getText()+", Zahl: "+bean.getZahl()+", Datum: "+bean.getDatum());
			}
			
			@Override
			protected void onError()
			{
				StandardTypesBean bean = getModelObject();
				error("Text: "+bean.getText()+", Zahl: "+bean.getZahl()+", Datum: "+bean.getDatum());
			}
		};
		
		form.add(new TextField<String>("Text"));
		
		form.add(new TextField<Double>("Zahl"));
		
		form.add(new DateTextField("Datum","dd.MM.yyyy 'um' HH:mm:ss"));
		
		add(form);
	}
}
