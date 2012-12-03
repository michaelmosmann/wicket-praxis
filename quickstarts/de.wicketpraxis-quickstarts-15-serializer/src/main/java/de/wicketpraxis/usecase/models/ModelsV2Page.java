package de.wicketpraxis.usecase.models;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class ModelsV2Page extends WebPage
{
	public ModelsV2Page()
	{
		IModel<Date> dateModel = new DateModel();

		IModel<Date> dateModel2 = new DateModel();

		add(new Label("now", dateModel));
		add(new Label("now2", dateModel2));
		
		setStatelessHint(false);
	}
	
	private final class DateModel extends LoadableDetachableModel<Date>
	{
		@Override
		protected Date load()
		{
			return new Date();
		}
	}

}
