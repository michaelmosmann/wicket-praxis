package de.wicketpraxis.seoajax;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class AjaxBookmarkablePageLink<T, P extends WebPage> extends AjaxLink<T> {

	public AjaxBookmarkablePageLink(String id, IModel<T> model) {
		super(id, model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		// use pushState if possible
		// see https://github.com/defunkt/jquery-pjax

		add(new AttributeModifier("href", new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				return getDestination(getModelObject()).asUrl();
			}
		}));
	}

	protected abstract BookmarkablePageDestination<P> getDestination(T modelValue);

}
