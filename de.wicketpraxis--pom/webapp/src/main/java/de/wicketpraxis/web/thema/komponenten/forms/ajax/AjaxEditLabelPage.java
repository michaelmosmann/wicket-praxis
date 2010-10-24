/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.ajax;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableChoiceLabel;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableLabel;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableMultiLineLabel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

@TitleAnnotation(title="AjaxEditable<?>")
public class AjaxEditLabelPage extends AbstractFormPage
{
	public AjaxEditLabelPage()
	{
		add(new AjaxEditableLabel<String>("ajaxLabel",Model.of("Label"))
		{
			@Override
			protected void onSubmit(AjaxRequestTarget target)
			{
				super.onSubmit(target);
				info("Label: "+getDefaultModelObject());
				updateFeedbackPanel(target);
			}
		});
		
		add(new AjaxEditableMultiLineLabel<String>("ajaxMultiLine",Model.of("Das\nist\nmehrzeilig")));
				
		final ListModel<String> choices = new ListModel<String>(Arrays.asList("der erste","der zweite","der dritte"));
		add(new AjaxEditableChoiceLabel<String>("ajaxChoice",Model.of("klicken und wählen"),choices)
		{
			@Override
			protected void onSubmit(AjaxRequestTarget target)
			{
				super.onSubmit(target);
				info("Choice: "+getDefaultModelObject());
				updateFeedbackPanel(target);
			}
		});
	}
}
