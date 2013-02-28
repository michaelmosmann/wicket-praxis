package de.wicketpraxis.seoajax;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SeoPage extends WebPage {

	public SeoPage(PageParameters pageParameters) {
		final IModel<IState> stateModel = StateConverter.asModel(pageParameters);

		final WebMarkupContainer ajaxUpdate = new WebMarkupContainer("ajaxUpdate");
		ajaxUpdate.setOutputMarkupId(true);

		ajaxUpdate.add(new Label("count", new PropertyModel<Integer>(stateModel, "counter")));

		ajaxUpdate.add(new CountLink("up", stateModel, ajaxUpdate) {

			@Override
			protected IState nextState(IState state) {
				return state.oneUp();
			}
		});

		ajaxUpdate.add(new CountLink("down", stateModel, ajaxUpdate) {

			@Override
			protected IState nextState(IState state) {
				return state.oneDown();
			}
		});

		add(ajaxUpdate);
	}
}
