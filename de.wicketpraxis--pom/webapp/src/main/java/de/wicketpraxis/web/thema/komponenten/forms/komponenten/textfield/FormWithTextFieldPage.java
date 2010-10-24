/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormWithTextFieldPage extends AbstractFormPage
{
	public FormWithTextFieldPage()
	{
		Form form = new Form("form")
		{
			@Override
			protected void onSubmit()
			{
				info("Hat geklappt");
			}
			
			@Override
			protected void onError()
			{
				error("Es gab da einen Fehler.");
			}
		};
		TextField<String> textField = new TextField<String>("Text",new Model<String>());
		textField.setRequired(true);
		form.add(textField);
		
		TextField<Integer> textField2 = new TextField<Integer>("Zahl",new Model<Integer>(),Integer.class);
		textField2.setRequired(true);
		form.add(textField2);
		form.add(new Button("submit"));
		add(form);
	}
}
