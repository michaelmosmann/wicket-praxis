/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.check;

import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.CheckGroupSelector;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.CheckBoxBean;

public class CheckGroupPage extends AbstractFormPage
{
	public CheckGroupPage()
	{
		Form<CheckBoxBean> form = new Form<CheckBoxBean>("form",new CompoundPropertyModel<CheckBoxBean>(new CheckBoxBean()))
		{
			@Override
			protected void onSubmit()
			{
				CheckBoxBean bean = getModelObject();
				info("Liste: " + bean.getListe());
			}
		};
		
		
		CheckGroup<String> checkGroup = new CheckGroup<String>("Liste");
		checkGroup.add(new Check<String>("handtuch",Model.of("Handtuch")));
		checkGroup.add(new Check<String>("seife",Model.of("Seife")));
		checkGroup.add(new Check<String>("stoepsel",Model.of("Stöpsel")));
		checkGroup.add(new CheckGroupSelector("alles",checkGroup));
		form.add(checkGroup);
		add(form);
	}
	
}
