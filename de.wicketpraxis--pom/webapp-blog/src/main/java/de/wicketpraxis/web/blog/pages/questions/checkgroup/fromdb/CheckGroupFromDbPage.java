/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.blog.pages.questions.checkgroup.fromdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class CheckGroupFromDbPage extends WebPage {

	@SpringBean
	UserDao _userDao;

	public CheckGroupFromDbPage() {
		LoadableDetachableModel<List<User>> userListModel = new LoadableDetachableModel<List<User>>() {

			@Override
			protected List<User> load() {
				return _userDao.findAll(0, 10);
			}
		};

		final IModel<Collection<Integer>> selectedModel = new CollectionModel<Integer>(new ArrayList<Integer>());

		add(new FeedbackPanel("feedback"));

		Form<Void> form = new Form<Void>("form") {

			@Override
			protected void onSubmit() {
				info("Elemente selectiert: " + selectedModel.getObject());
			}
		};

		CheckGroup<Integer> checkGroup = new CheckGroup<Integer>("checkGroup", selectedModel);
		form.add(checkGroup);

		checkGroup.add(new ListView<User>("list", userListModel) {

			@Override
			protected void populateItem(ListItem<User> item) {
				item.add(new Check<Integer>("check", Model.of(item.getModelObject().getId())));
				item.add(new Label("name", item.getModelObject().getName()));
			}
		});

		add(form);

	}
}
