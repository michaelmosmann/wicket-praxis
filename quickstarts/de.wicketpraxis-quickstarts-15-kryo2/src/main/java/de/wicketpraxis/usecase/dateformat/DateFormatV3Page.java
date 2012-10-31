package de.wicketpraxis.usecase.dateformat;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;

public class DateFormatV3Page extends WebPage
{
	public DateFormatV3Page()
	{
		add(new Label("now", new DateModel()));
		add(new Label("now2", new DateModel()));

		setStatelessHint(false);
	}

	static class DateModel extends LoadableDetachableModel<FullDate>
	{
		@Override
		protected FullDate load()
		{
			return new FullDate(new Date());
		}
	}
}
