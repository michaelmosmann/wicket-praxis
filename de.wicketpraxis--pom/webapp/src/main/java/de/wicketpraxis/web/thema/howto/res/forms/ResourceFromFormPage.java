/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.forms;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.target.resource.ResourceStreamRequestTarget;
import org.apache.wicket.util.resource.StringResourceStream;

public class ResourceFromFormPage extends WebPage
{
	public ResourceFromFormPage()
	{
		Form form = new Form("form")
		{
			@Override
			protected void onSubmit()
			{
				StringResourceStream output=new StringResourceStream("1,2,3","text/plain");
				ResourceStreamRequestTarget target=new ResourceStreamRequestTarget(output,"data.csv");
				RequestCycle.get().setRequestTarget(target);
			}
		};
		
		add(form);
	}
}
