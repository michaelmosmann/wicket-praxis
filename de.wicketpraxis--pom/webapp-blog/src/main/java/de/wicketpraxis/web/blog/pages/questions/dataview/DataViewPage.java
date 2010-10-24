package de.wicketpraxis.web.blog.pages.questions.dataview;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigatorLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.blog.pages.questions.data.SomeBean;
import de.wicketpraxis.web.blog.pages.questions.data.SomeBeanDataProvider;
import de.wicketpraxis.web.blog.pages.questions.data.SomeBeanFilter;

public class DataViewPage extends WebPage
{
	public DataViewPage()
	{
		SomeBeanDataProvider dataProvider=new SomeBeanDataProvider();
		
		Form<SomeBeanFilter> form = new Form<SomeBeanFilter>("form",new CompoundPropertyModel<SomeBeanFilter>(dataProvider.getFilterState()));
		form.add(new TextField<String>("name"));
		form.add(new TextField<String>("vorname"));
		
		form.add(new OrderByLink("sortName","name",dataProvider));
		form.add(new OrderByLink("sortAlter","alter",dataProvider));
		
		DataView<SomeBean> dataView = new DataView<SomeBean>("dataView",dataProvider)
		{
			@Override
			protected void populateItem(Item<SomeBean> item)
			{
				item.setDefaultModel(new CompoundPropertyModel<SomeBean>(item.getModel()));
//				WebMarkupContainer helper = new WebMarkupContainer("modelHelper",new CompoundPropertyModel<SomeBean>(item.getModel()));
				item.add(new Label("vorname"));
				item.add(new Label("name"));
				item.add(new Label("alter"));
//				item.add(helper);
			}
		};
		dataView.setItemsPerPage(10);
		
		form.add(new PagingNavigator("navigator",dataView));
		form.add(new NavigatorLabel("label",dataView));
		
		form.add(dataView);
		
		add(form);
	}
}
