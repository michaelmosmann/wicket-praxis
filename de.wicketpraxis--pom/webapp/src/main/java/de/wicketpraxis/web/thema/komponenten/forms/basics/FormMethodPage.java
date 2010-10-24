/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import org.apache.wicket.markup.html.form.Form;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormMethodPage extends AbstractFormPage
{
	public FormMethodPage()
	{
		add(new Form("formPost")
		{
			@Override
			protected void onSubmit()
			{
				info("Form mit POST");
			}
		});
		
		Form formGet = new Form("formGet")
		{
			@Override
			protected void onSubmit()
			{
				info("Form mit GET");
				setRedirect(false);
			}
			
			@Override
			protected String getMethod()
			{
				return Form.METHOD_GET;
			}
		};
		add(formGet);
	}
}
