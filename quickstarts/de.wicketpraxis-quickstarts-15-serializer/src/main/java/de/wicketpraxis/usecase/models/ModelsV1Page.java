package de.wicketpraxis.usecase.models;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class ModelsV1Page extends WebPage
{
	public ModelsV1Page()
	{
		final IModel<Date> dateModel = new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};
		
		IModel<String> dateAsString = new AbstractReadOnlyModel<String>() {
			
			@Override
			public String getObject() {
				return ""+dateModel.getObject();
			}
		};

		add(new Label("now", dateAsString));
		
		setStatelessHint(false);
	}
}
