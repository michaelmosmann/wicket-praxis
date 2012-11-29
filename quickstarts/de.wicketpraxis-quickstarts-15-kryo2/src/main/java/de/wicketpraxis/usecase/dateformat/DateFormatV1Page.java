package de.wicketpraxis.usecase.dateformat;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class DateFormatV1Page extends WebPage
{
	public DateFormatV1Page()
	{
		add(new Label("now", new DateToStringModel(new DateModel())));
		add(new Label("now2", new DateToStringModel(new DateModel())));

		setStatelessHint(false);
	}

	static class DateToStringModel extends LoadableDetachableModel<String>
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		private final IModel<Date> dateModel;

		public DateToStringModel(IModel<Date> dateModel)
		{
			this.dateModel = dateModel;
		}

		@Override
		protected String load()
		{
			return dateFormat.format(dateModel.getObject());
		}

		@Override
		protected void onDetach()
		{
			super.onDetach();
			dateModel.detach();
		}
	}
}
