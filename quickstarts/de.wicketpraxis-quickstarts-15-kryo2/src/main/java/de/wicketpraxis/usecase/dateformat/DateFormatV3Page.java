package de.wicketpraxis.usecase.dateformat;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;

public class DateFormatV3Page extends WebPage
{
	public DateFormatV3Page()
	{
		add(new Label("now", new DateModel(false)));
		add(new Label("now2", new DateModel(true)));

		setStatelessHint(false);
	}

	static class DateModel extends LoadableDetachableModel<AbstractDateContainer>
	{
		private final boolean full;

		public DateModel(boolean full)
		{
			this.full = full;
		}

		@Override
		protected AbstractDateContainer load()
		{
			return full ? new FullDate(new Date()) : new SmallDate(new Date());
		}
	}
}
