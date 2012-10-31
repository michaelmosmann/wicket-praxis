package de.wicketpraxis.usecase.models;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class ModelsV1Page extends WebPage
{
	public ModelsV1Page()
	{
		IModel<Date> dateModel = new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};

		IModel<Date> dateModel2 = new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};

		add(new Label("now", dateModel));
		add(new Label("now2", dateModel2));
		
		setStatelessHint(false);
	}
}
