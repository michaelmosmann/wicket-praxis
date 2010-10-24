package de.wicketpraxis.web.blog.pages.questions.datatable;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.blog.pages.questions.data.SomeBean;
import de.wicketpraxis.web.blog.pages.questions.data.SomeBeanDataProvider;

public class DataTablePage extends WebPage
{
	public DataTablePage()
	{
		List<IColumn<SomeBean>> columns=new ArrayList<IColumn<SomeBean>>();
		columns.add(new TextFilteredPropertyColumn<SomeBean,String>(Model.of("Vorname"),"vorname"));
		columns.add(new TextFilteredPropertyColumn<SomeBean,String>(Model.of("Name"),"name","name"));
		columns.add(new PropertyColumn<SomeBean>(Model.of("Alter"),"alter","alter"));
		
		SomeBeanDataProvider dataProvider=new SomeBeanDataProvider();
		
		FilterForm form=new FilterForm("form",dataProvider);
		
		DefaultDataTable<SomeBean> dataTable = new DefaultDataTable<SomeBean>("dataTable",columns,dataProvider,10);
		dataTable.addTopToolbar(new FilterToolbar(dataTable,form,dataProvider));
		form.add(dataTable);
		
		add(form);
	}
}
