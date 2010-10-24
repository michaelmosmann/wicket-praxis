/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.formcomplabel;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponentLabel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormCompLabelPage extends AbstractFormPage
{
	public FormCompLabelPage()
	{
		Form form = new Form("form");
		
		TextField<String> textField = new TextField<String>("text",new Model<String>());
		FormComponentLabel label = new FormComponentLabel("label",textField);
		/*
	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		super.onComponentTag(tag);
		checkComponentTag(tag, "label");
		tag.put("for", component.getMarkupId());
	}
		 */
		form.add(label);
		form.add(textField);
		
		add(form);

	}
}
