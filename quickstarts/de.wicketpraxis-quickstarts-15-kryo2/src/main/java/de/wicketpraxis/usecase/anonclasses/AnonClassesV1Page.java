package de.wicketpraxis.usecase.anonclasses;

import java.util.Date;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

public class AnonClassesV1Page extends WebPage
{
	public AnonClassesV1Page()
	{
		final IModel<String> labelText = Model.of("Now");

		IModel<Date> dateModel = new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};

		add(new DatePanel("now", "datepanel", this, dateModel)
		{
			@Override
			public IModel<String> label()
			{
				return labelText;
			}
		});
		add(new DatePanel("now2", "datepanel", this, dateModel)
		{
			@Override
			public IModel<String> label()
			{
				return labelText;
			}
		});

		setStatelessHint(false);
	}

	static class DatePanel extends Fragment
	{
		public DatePanel(String id, String markupId, MarkupContainer markupProvider,
			IModel<Date> model)
		{
			super(id, markupId, markupProvider);

			add(new Label("date", model));
			add(new Label("label", label()));
		}

		public IModel<String> label()
		{
			return Model.of("Date");
		}

	}
}
