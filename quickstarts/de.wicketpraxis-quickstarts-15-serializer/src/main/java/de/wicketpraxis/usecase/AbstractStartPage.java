package de.wicketpraxis.usecase;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.wicketpraxis.AutoLabelBookmarkablePageLink;

public abstract class AbstractStartPage extends WebPage
{
	public AbstractStartPage(String title, Class<? extends WebPage>... pages)
	{
		add(new Label("title", title));
		add(new ListView<Class<? extends WebPage>>("pages", Arrays.asList(pages))
		{
			@Override
			protected void populateItem(ListItem<Class<? extends WebPage>> item)
			{
				item.add(AutoLabelBookmarkablePageLink.with("link", item.getModelObject()));
			}
		});

	}
}
