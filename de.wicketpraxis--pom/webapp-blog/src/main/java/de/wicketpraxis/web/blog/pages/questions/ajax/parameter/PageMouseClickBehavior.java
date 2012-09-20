package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

public abstract class PageMouseClickBehavior extends AbstractParameterizedDefaultAjaxBehavior {

	static final Parameter<Integer> MOUSE_X = of("x", Integer.class, "x");
	static final Parameter<Integer> MOUSE_Y = of("y", Integer.class, "y");

	String _contentId;

	public PageMouseClickBehavior() {
	}

	public PageMouseClickBehavior(String contentId) {
		_contentId = contentId;
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(JavaScriptReferenceHeaderItem.forReference(WicketWindowJavascript.RESOURCE));
		response.render(JavaScriptReferenceHeaderItem.forReference(new PackageResourceReference(PageMouseClickBehavior.class, "PageMouseClickBehavior.js")));
		response.render(OnDomReadyHeaderItem.forScript(getJavascript()));
	}

	protected String getJavascript() {
		if (_contentId != null)
			return "PageMouseClickBehavoir.init(function (x,y,xOffset,yOffset) {" + getCallbackScript() + "},'" + _contentId
					+ "');";
		return "PageMouseClickBehavoir.init(function (x,y,xOffset,yOffset) {" + getCallbackScript() + "});";
	}

	@Override
	protected Parameter<?>[] getParameter() {
		return new Parameter<?>[] {MOUSE_X, MOUSE_Y};
	}

	@Override
	protected void respond(AjaxRequestTarget target, ParameterMap map) {
		onClick(target, map.getValue(MOUSE_X), map.getValue(MOUSE_Y));
	}

	protected abstract void onClick(AjaxRequestTarget target, int x, int y);
}
