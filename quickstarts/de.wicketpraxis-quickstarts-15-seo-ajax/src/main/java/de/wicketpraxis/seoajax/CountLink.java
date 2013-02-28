package de.wicketpraxis.seoajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

public abstract class CountLink extends AjaxBookmarkablePageLink<IState, SeoPage> {

	private final WebMarkupContainer _ajaxBorder;

	public CountLink(String id, IModel<IState> model, WebMarkupContainer ajaxBorder) {
		super(id, model);
		_ajaxBorder = ajaxBorder;
	}

	@Override
	protected BookmarkablePageDestination<SeoPage> getDestination(IState state) {
		return BookmarkablePageDestination.with(SeoPage.class, StateConverter.asPageParameters(nextState(state)));
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		setModelObject(nextState(getModelObject()));
		target.add(_ajaxBorder);
	}

	protected abstract IState nextState(IState state);
}
