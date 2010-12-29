/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilteredColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilter;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "FilterDataTable - erstmal nicht", space = true)
public class FilterDataTablePage extends WebPage {

	@SpringBean
	UserDao _userDao;

	public FilterDataTablePage() {
		UserList data = new UserList(_userDao);

		List<IColumn<User>> columns = new ArrayList<IColumn<User>>();
		columns.add(new PropertyColumn<User>(Model.of("Id"), "id", "Id"));
		columns.add(new FilterEmailColumn(Model.of("EMail"), "EMail", "EMail"));

		FilterForm form = new FilterForm("form", data);

		DefaultDataTable<User> table = new DefaultDataTable<User>("list", columns, data, 3);
		table.addTopToolbar(new FilterToolbar(table, form, data));

		form.add(table);
		add(form);
	}

	static class FilterEmailColumn extends PropertyColumn<User> implements IFilteredColumn<User> {

		public FilterEmailColumn(IModel<String> displayModel, String sortProperty, String propertyExpression) {
			super(displayModel, sortProperty, propertyExpression);
		}

		public Component getFilter(String componentId, FilterForm form) {
			return new TextFilter<String>(componentId, new PropertyModel<String>(form.getModel(), "EMail"), form);
		}

	}
}
