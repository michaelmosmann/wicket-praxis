package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;

import de.wicketpraxis.web.blog.pages.questions.ajax.parameter.AbstractParameterizedDefaultAjaxBehavior.Parameter;

public abstract class ElementOffsetBehavior extends AbstractParameterizedDefaultAjaxBehavior {

	static final Parameter<Integer> X_OFFSET = of("xOffset", Integer.class, "xOffset");
	static final Parameter<Integer> Y_OFFSET = of("yOffset", Integer.class, "yOffset");

	private String _contentId;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderJavascriptReference(WicketWindowJavascript.RESOURCE);
		response.renderJavascriptReference(new ResourceReference(ElementOffsetBehavior.class, "ElementOffsetBehavior.js"));
		response.renderOnDomReadyJavascript(getJavascript());
	}

	public ElementOffsetBehavior() {

	}

	public ElementOffsetBehavior(String contentId) {
		_contentId = contentId;
	}

	protected final String getJavascript() {
		if (_contentId != null)
			return "ElementOffsetBehavoir.init(function (xOffset,yOffset) {" + getCallbackScript() + "},'" + _contentId
					+ "');";
		return "ElementOffsetBehavoir.init(function (xOffset,yOffset) {" + getCallbackScript() + "});";
	}

	@Override
	protected final Parameter<?>[] getParameter() {
		return new Parameter<?>[] {X_OFFSET, Y_OFFSET};
	}

	@Override
	protected void respond(AjaxRequestTarget target, ParameterMap parameterMap) {
		onOffset(target, parameterMap.getValue(X_OFFSET), parameterMap.getValue(Y_OFFSET));
	}

	protected abstract void onOffset(AjaxRequestTarget target, int xOffset, int yOffset);
}
