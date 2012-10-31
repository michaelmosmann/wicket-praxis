package de.wicketpraxis.usecase.dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converter.DateConverter;

public class DateFormatV2Page extends WebPage
{
	public DateFormatV2Page()
	{
		add(new DateLabel("now", new DateModel()));
		add(new DateLabel("now2", new DateModel()));

		setStatelessHint(false);
	}

	static class DateModel extends LoadableDetachableModel<Date>
	{
		@Override
		protected Date load()
		{
			return new Date();
		}
	}

	static class DateLabel extends Label
	{
		public DateLabel(String id, IModel<Date> model)
		{
			super(id, model);
		}

		@Override
		public <T> IConverter<T> getConverter(Class<T> type)
		{
			return (IConverter<T>)new DateConverter()
			{
				@Override
				public DateFormat getDateFormat(Locale locale)
				{
					return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				}
			};
		}

	}
}
