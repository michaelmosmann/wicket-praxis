/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.basepage.nav;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.wicketpraxis.web.model.CascadingLoadableDetachableModel;

public class NavPanel extends Panel {

	int _level = 0;

	public NavPanel(String id, IModel<NavCallbackInterface> callbackModel) {
		super(id);

		initPanel(callbackModel);
	}

	public NavPanel(String id, IModel<NavCallbackInterface> callbackModel, int level) {
		super(id);

		_level = level;

		initPanel(callbackModel);
	}

	private void initPanel(IModel<NavCallbackInterface> callbackModel) {
		final IModel<String> nameModel = new PropertyModel<String>(callbackModel, "Name");

		CascadingLoadableDetachableModel<String, NavCallbackInterface> classModel = new CascadingLoadableDetachableModel<String, NavCallbackInterface>(
				callbackModel) {

			@Override
			protected String load(NavCallbackInterface p) {
				return p.isActive(getPage())
						? "active"
						: null;
			}
		};

		Link<NavCallbackInterface> link = new Link<NavCallbackInterface>("link", callbackModel) {

			@Override
			public void onClick() {
				getModelObject().onClick(getPage());
			}

			@Override
			protected void onBeforeRender() {
				super.onBeforeRender();
				if (nameModel.getObject() == null)
					setVisible(false);
				else
					setVisible(true);
			}
		};
		link.add(new Label("name", nameModel));
		link.add(new AttributeAppender("class", true, classModel, " "));
		link.add(new AttributeAppender("class", true, Model.of("level" + _level), " "));
		add(link);

		CascadingLoadableDetachableModel<List<NavCallbackInterface>, NavCallbackInterface> childModel = new CascadingLoadableDetachableModel<List<NavCallbackInterface>, NavCallbackInterface>(
				callbackModel) {

			@Override
			protected List<NavCallbackInterface> load(NavCallbackInterface p) {
				return p.getChilds(getPage());
			}
		};

		add(new ListView<NavCallbackInterface>("childs", childModel) {

			@Override
			protected void populateItem(ListItem<NavCallbackInterface> item) {
				item.add(new NavPanel("child", item.getModel(), _level + 1));
			}
		});
	}
}
