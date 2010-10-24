package de.wicketpraxis.web.blog.pages.questions.email;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

public class EmailContentPage extends WebPage
{
	public EmailContentPage(IModel<List<? extends String>> list)
	{
		add(new ListView<String>("list",list)
		{
			@Override
			protected void populateItem(ListItem<String> item)
			{
				item.add(new Label("name",item.getModel()));
			}
		});
	}
}
