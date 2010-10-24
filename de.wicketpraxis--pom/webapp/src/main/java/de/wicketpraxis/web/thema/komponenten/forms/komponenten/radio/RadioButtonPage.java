/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.radio;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.StandardTypesBean;

@TitleAnnotation(title="Radio Buttons",space=true)
public class RadioButtonPage extends AbstractFormPage
{
	public RadioButtonPage()
	{
		Form<StandardTypesBean> form = new Form<StandardTypesBean>("form",new CompoundPropertyModel<StandardTypesBean>(new StandardTypesBean()))
		{
			@Override
			protected void onSubmit()
			{
				StandardTypesBean bean = getModelObject();
				info("Zahl: " + bean.getZahl());
				info("Text: " + bean.getText());
			}
		};
		RadioGroup<Integer> radioGroup = new RadioGroup<Integer>("Zahl");
		radioGroup.add(new Radio<Integer>("Zahl1",Model.of(1)));
		radioGroup.add(new Radio<Integer>("Zahl2",Model.of(2)));
		radioGroup.add(new Radio<Integer>("Zahl4",Model.of(4)));
		radioGroup.setRequired(true);
		form.add(radioGroup);
		form.add(new RadioChoice<String>("Text", Arrays.asList("Haus", "Baum", "Auto")));
		add(form);
	}
}