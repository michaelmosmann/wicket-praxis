/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Data View",space=true)
public class DataViewPage extends WebPage
{
	public DataViewPage()
	{
		IDataProvider<String> data=new IDataProvider<String>()
		{
			public Iterator<? extends String> iterator(int first, int count)
			{
				List<String> tempList=new ArrayList<String>();
				for (int i=0;i<count;i++)
				{
					tempList.add("Position "+(i+first));
				}
				return tempList.iterator();
			}

			public IModel<String> model(String object)
			{
				return Model.of(object);
			}

			public int size()
			{
				return 124;
			}

			public void detach() { /* hier nicht nötig */	}
			
		};
		
		final DataView<String> dataView = new DataView<String>("list",data,10)
		{
			@Override
			protected void populateItem(Item<String> item)
			{
				item.add(new Label("label",item.getModel()));
			}
		};
		add(dataView);
		
		add(new Link("link")
		{
			@Override
			public void onClick()
			{
				int page = dataView.getCurrentPage()+1;
				if (page<dataView.getPageCount()) dataView.setCurrentPage(page);
			}
		});
		
	}
}
