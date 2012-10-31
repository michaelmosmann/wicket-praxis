package de.wicketpraxis.usecase.anonclasses;

import java.util.Date;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

public class AnonClassesV2Page extends WebPage
{
	public AnonClassesV2Page()
	{
		IModel<String> labelText = Model.of("Now");

		IModel<Date> dateModel = new LoadableDetachableModel<Date>()
		{
			@Override
			protected Date load()
			{
				return new Date();
			}
		};

		add(new DatePanel("now", "datepanel", this, dateModel,labelText));
		add(new DatePanel("now2", "datepanel", this, dateModel,labelText));

		setStatelessHint(false);
	}

	static class DatePanel extends Fragment
	{
		public DatePanel(String id, String markupId, MarkupContainer markupProvider,
			IModel<Date> model,IModel<String> labelModel)
		{
			super(id, markupId, markupProvider);

			add(new Label("date", model));
			add(new Label("label", labelModel));
		}
	}
}
