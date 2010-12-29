package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.util.time.Duration;

public abstract class WindowResizeBehavior extends AbstractParameterizedDefaultAjaxBehavior {

	static final Parameter<Integer> WIDTH = of("width", Integer.class, "Wicket.Window.getViewportWidth()");
	static final Parameter<Integer> HEIGHT = of("height", Integer.class, "Wicket.Window.getViewportHeight()");

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderJavascriptReference(WicketWindowJavascript.RESOURCE);
		response.renderOnDomReadyJavascript(getJavascript());
		response.renderOnDomReadyJavascript(getCallbackScript().toString());
	}

	protected final String getJavascript() {
		return "window.onresize = Callback.create(window.onresize,function () {" + getCallbackScript() + "});";
	}

	@Override
	protected final Parameter<?>[] getParameter() {
		return new Parameter<?>[] {WIDTH, HEIGHT};
	}

	@Override
	protected void respond(AjaxRequestTarget target, ParameterMap parameterMap) {
		onResize(target, parameterMap.getValue(WIDTH), parameterMap.getValue(HEIGHT));
	}

	protected abstract void onResize(AjaxRequestTarget target, int width, int height);
}
