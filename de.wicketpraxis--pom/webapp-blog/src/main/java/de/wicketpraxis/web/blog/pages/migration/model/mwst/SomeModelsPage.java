package de.wicketpraxis.web.blog.pages.migration.model.mwst;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.wicketpraxis.web.blog.model.CascadingLoadableDetachableModel;

public class SomeModelsPage extends WebPage
{
	public SomeModelsPage()
	{
		ResultListModel resultList=new ResultListModel();
		
		add(new PropertyListView<Result>("list",resultList)
		{
			@Override
			protected void populateItem(ListItem<Result> item)
			{
				IModel<Result> model = item.getModel();
				item.add(new Label("name",new PropertyModel<String>(model,"name")));
				item.add(new Label("betrag"));
				item.add(new Label("mwst",new MwStAnteilModel(new PropertyModel<Double>(model,"betrag"))));
			}
		});

		IModel<Double> summeModel = new CascadingLoadableDetachableModel<Double, List<Result>>(resultList)
		{
			@Override
			protected Double load(List<Result> liste)
			{
				if (liste!=null)
				{
					double summe=0;
					for (Result r : liste)
					{
						summe=summe+r.getBetrag();
					}
					return summe;
				}
				return null;
			}
		};
		
		add(new Label("summe",summeModel));
		add(new Label("mwst",new MwStAnteilModel(summeModel)));	
	}
}
