package de.wicketpraxis.web.blog.pages.migration.model.property;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.wicketpraxis.wicket.model.Models;
import de.wicketpraxis.wicket.model.transformation.Function1;

public class UseOrNotUsePropertyModelPage extends WebPage {

	public UseOrNotUsePropertyModelPage() {
		final Generator gen = new Generator();

		add(new Label("toString", gen.toString()));

		IModel<List<String>> model = new LoadableDetachableModel<List<String>>() {

			protected List<String> load() {
				return gen.findAll();
			};
		};

		model = Models.on(Model.of(gen)).apply(new Function1<List<String>, Generator>() {

			public List<String> apply(Generator value) {
				return value.findAll();
			}
		});

		model = new PropertyModel<List<String>>(gen, "findAll");

		add(new ListView<String>("list", model) {

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("value", item.getModel()));
			}
		});
	}
}
