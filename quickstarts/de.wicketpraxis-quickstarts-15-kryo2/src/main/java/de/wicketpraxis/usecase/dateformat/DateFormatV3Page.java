package de.wicketpraxis.usecase.dateformat;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class DateFormatV3Page extends WebPage
{
	public DateFormatV3Page()
	{
		add(new Label("now", new DateContainerModel(false)));
		add(new Label("now2", new DateContainerModel(true)));

		setStatelessHint(false);
	}
}
