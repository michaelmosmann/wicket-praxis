package de.wicketpraxis.usecase.listview;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class ListViewV2Page extends WebPage
{
	public ListViewV2Page()
	{
		add(new ListView<String>("list",Arrays.asList("Sun","Fun","Sport")){
			@Override
			protected void populateItem(ListItem<String> item)
			{
				item.add(new Label("label",new BigStringModel(item.getModel())));
			}
		});
		
		setStatelessHint(false);
	}
	
	static class BigStringModel extends LoadableDetachableModel<String> {

		IModel<String> source;
		
		public BigStringModel(IModel<String> source)
		{
			this.source = source;
		}
		
		@Override
		protected String load()
		{
			return big(source.getObject());
		}
		
		@Override
		protected void onDetach()
		{
			super.onDetach();
			source.detach();
		}
		
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
