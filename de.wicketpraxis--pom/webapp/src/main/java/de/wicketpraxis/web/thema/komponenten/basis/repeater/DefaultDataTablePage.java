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

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Default DataTable")
public class DefaultDataTablePage extends WebPage {

	@SpringBean
	UserDao _userDao;

	public DefaultDataTablePage() {
		UserList data = new UserList(_userDao);

		List<IColumn<User,String>> columns = new ArrayList<IColumn<User,String>>();
		columns.add(new PropertyColumn<User,String>(Model.of("Id"), "id", "Id"));
		columns.add(new PropertyColumn<User,String>(Model.of("EMail"), "EMail", "EMail"));
		columns.add(new AbstractColumn<User,String>(Model.of("")) {

			public void populateItem(Item<ICellPopulator<User>> cellItem, String componentId, IModel<User> rowModel) {
				Fragment fragment = new Fragment(componentId, "deleteFragment", DefaultDataTablePage.this);
				fragment.add(new Link<User>("link", rowModel) {

					@Override
					public void onClick() {
						User user = getModelObject();
						_userDao.delete(user);
					}
				});
				cellItem.add(fragment);
			}
		});

		DefaultDataTable<User,String> table = new DefaultDataTable<User,String>("list", columns, data, 3);
		// Bug mit der sichtbarkeit der NavigationToolbar in 1.4-rc2
		//		table.addTopToolbar(new NavigationToolbar(table));
		add(table);
	}
}
