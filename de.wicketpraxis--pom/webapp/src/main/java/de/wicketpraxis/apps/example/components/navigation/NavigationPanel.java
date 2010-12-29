/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.navigation;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.apps.example.components.navigation.model.ChildListModel;
import de.wicketpraxis.apps.example.components.navigation.model.ConditionalPassModel;
import de.wicketpraxis.apps.example.components.navigation.model.NavActiveModel;
import de.wicketpraxis.apps.example.components.navigation.model.PageModel;

public class NavigationPanel extends Panel {

	private static final Logger _logger = LoggerFactory.getLogger(NavigationPanel.class);

	PageModel _pageModel;

	public NavigationPanel(String id, IModel<List<NavigationCallbackInterface>> navigationModel) {
		super(id);

		_pageModel = new PageModel(this);

		add(new NavListView("main", navigationModel));
	}

	static class NavListView extends ListView<NavigationCallbackInterface> {

		IModel<NavigationCallbackInterface> _parent;
		IModel<Boolean> _activeModel = Model.of(Boolean.TRUE);
		PageModel _pageModel = new PageModel(this);

		public NavListView(String id, IModel<? extends List<? extends NavigationCallbackInterface>> model) {
			super(id, model);
		}

		public NavListView(String id, IModel<? extends List<? extends NavigationCallbackInterface>> model,
				IModel<NavigationCallbackInterface> parent) {
			super(id, model);
			_parent = parent;
			_activeModel = new NavActiveModel(_parent, _pageModel);
		}

		@Override
		protected void populateItem(ListItem<NavigationCallbackInterface> item) {
			IModel<NavigationCallbackInterface> model = item.getModel();
			Link<NavigationCallbackInterface> link = new Link<NavigationCallbackInterface>("link", model) {

				@Override
				public void onClick() {
					getModel().getObject().onClick(getPage());
				}
			};
			Label label = new Label("name", new PropertyModel<String>(model, "name"));
			label.add(new AttributeAppender("class", true, ConditionalPassModel.getModel(
					new NavActiveModel(model, _pageModel), Model.of("active")), " "));
			link.add(label);
			item.add(link);
			if (_parent == null)
				item.add(new NavListView("sub", new ChildListModel(model), model));
			else {
				//				item.add(new NavListView("sub",new ListModel<NavigationCallbackInterface>(),model));
			}
		}

		@Override
		protected void onBeforeRender() {
			setVisible(_activeModel.getObject().booleanValue());
			super.onBeforeRender();
		}
	}
}
