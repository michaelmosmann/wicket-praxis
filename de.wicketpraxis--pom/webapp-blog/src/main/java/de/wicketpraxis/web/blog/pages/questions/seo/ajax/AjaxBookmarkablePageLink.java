package de.wicketpraxis.web.blog.pages.questions.seo.ajax;

import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.calldecorator.CancelEventIfNoAjaxDecorator;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;


public abstract class AjaxBookmarkablePageLink<T> extends BookmarkablePageLink<T> {

	public <C extends Page> AjaxBookmarkablePageLink(String id, Class<C> pageClass, PageParameters parameters) {
		super(id, pageClass, parameters);
		
		add(new AjaxEventBehavior("onclick") {
			@Override
			protected void onEvent(AjaxRequestTarget target) {
				AjaxBookmarkablePageLink.this.onclick(target);
			}
			
			@Override
			protected IAjaxCallDecorator getAjaxCallDecorator() {
				return new CancelEventIfNoAjaxDecorator(super.getAjaxCallDecorator());
			}
		});
	}

	protected abstract void onclick(AjaxRequestTarget target);
	
}
