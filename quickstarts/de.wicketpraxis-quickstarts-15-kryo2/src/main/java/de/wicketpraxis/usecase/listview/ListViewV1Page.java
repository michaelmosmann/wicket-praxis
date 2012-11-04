package de.wicketpraxis.usecase.listview;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;

public class ListViewV1Page extends WebPage
{
	public ListViewV1Page()
	{
		add(new ListView<String>("list",Arrays.asList("Sun","Fun","Sport")){
			@Override
			protected void populateItem(ListItem<String> item)
			{
				item.add(new Label("label",Model.of(big(item.getModelObject()))));
			}
		});
		
		setStatelessHint(false);
	}

	private static String big(String src)
	{
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<100;i++) {
			sb.append(src).append(" ");
		}
		return sb.toString();
	}
}
