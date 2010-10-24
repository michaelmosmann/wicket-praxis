/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.select;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.LieblingsfarbenBean;

public class ListMultipleChoicePage extends AbstractFormPage
{
	public ListMultipleChoicePage()
	{
		Form<LieblingsfarbenBean> form=new Form<LieblingsfarbenBean>("form",new CompoundPropertyModel<LieblingsfarbenBean>(new LieblingsfarbenBean()))
		{
			@Override
			protected void onSubmit()
			{
				LieblingsfarbenBean bean = getModelObject();
				info("Lieblingsfarben: "+bean.getLieblingsfarben());
			}
		};
		
		List<String> farben = Arrays.asList("Rot","Grün","Gelb","Ocker","Schwarz");
		form.add(new ListMultipleChoice<String>("Lieblingsfarben",farben).setMaxRows(3));
		
		add(form);
	}
}
