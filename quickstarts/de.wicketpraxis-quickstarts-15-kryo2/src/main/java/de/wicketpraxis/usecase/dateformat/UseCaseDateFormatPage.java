package de.wicketpraxis.usecase.dateformat;


import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UseCaseDateFormatPage extends WebPage
{
	public UseCaseDateFormatPage()
	{
		IModel<Date> dateModel=new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};
		add(new Label("now",dateModel));
		
		add(new Link<Void>("link") {
			@Override
			public void onClick()
			{
				
			}
		});
	}
}
