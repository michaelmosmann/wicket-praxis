package de.wicketpraxis.web.blog.pages.questions.datatable;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.blog.pages.questions.data.SomeBean;
import de.wicketpraxis.web.blog.pages.questions.data.SomeBeanDataProvider;
import de.wicketpraxis.web.blog.pages.questions.data.SomeBeanFilter;

public class DataTablePage extends WebPage {

	public DataTablePage() {
		List<IColumn<SomeBean>> columns = new ArrayList<IColumn<SomeBean>>();
		columns.add(new TextFilteredPropertyColumn<SomeBean, String>(Model.of("Vorname"), "vorname"));
		columns.add(new TextFilteredPropertyColumn<SomeBean, String>(Model.of("Name"), "name", "name"));
		columns.add(new PropertyColumn<SomeBean>(Model.of("Alter"), "alter", "alter"));

		SomeBeanDataProvider dataProvider = new SomeBeanDataProvider();

		FilterForm<SomeBeanFilter> form = new FilterForm<SomeBeanFilter>("form", dataProvider);

		DefaultDataTable<SomeBean> dataTable = new DefaultDataTable<SomeBean>("dataTable", columns, dataProvider, 10);
		dataTable.addTopToolbar(newFilterToolbar(dataTable, form, dataProvider));
		form.add(dataTable);

		add(form);
	}

	/**
	 * wicket 1.5 api missmatch - fixed in wicket 6
	 */
	private <T,F> FilterToolbar newFilterToolbar(DefaultDataTable<T> dataTable, FilterForm<F> form,
			IFilterStateLocator<F> dataProvider) {
		return new FilterToolbar(dataTable, (FilterForm) form, (IFilterStateLocator) dataProvider);
	}
}
