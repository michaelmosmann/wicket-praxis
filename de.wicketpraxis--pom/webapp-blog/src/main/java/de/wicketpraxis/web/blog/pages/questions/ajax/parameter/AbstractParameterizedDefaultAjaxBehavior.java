package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.time.Duration;

public abstract class AbstractParameterizedDefaultAjaxBehavior extends AbstractDefaultAjaxBehavior {

	static int sec = 0;

	private Duration _throttleDelay;

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.renderJavaScriptReference(new PackageResourceReference(AbstractParameterizedDefaultAjaxBehavior.class,
				"AbstractParameterizedDefaultAjaxBehavior.js"));
	}

	@Override
	protected void respond(AjaxRequestTarget target) {
		Request request = RequestCycle.get().getRequest();

		Map<String, Object> map = new HashMap<String, Object>();
		Parameter<?>[] parameter = getParameter();
		for (Parameter<?> p : parameter) {
			String svalue = request.getRequestParameters().getParameterValue(p.getName()).toString();
			if (svalue != null) {
				Object value = getComponent().getConverter(p.getType()).convertToObject(svalue, getComponent().getLocale());
				map.put(p.getName(), value);
			}
		}

		respond(target, new ParameterMap(map));
	}
	
	@Override
	public CharSequence getCallbackUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getCallbackUrl());

		Parameter<?>[] parameter = getParameter();
		for (Parameter<?> p : parameter) {
			sb.append("&").append(p.getName()).append("='+").append(p.getJavascript()).append("+'");
		}

		return sb.toString();
	}

	@Override
	protected final CharSequence getCallbackScript() {
		if (_throttleDelay != null) {
			return throttleScript(super.getCallbackScript(), "thw" + (sec++), _throttleDelay);
		}
		return super.getCallbackScript();
	}

	protected static class Parameter<T> {

		String _name;
		String _javascript;
		Class<T> _type;

		protected Parameter(String name, Class<T> type, String javascript) {
			_name = name;
			_type = type;
			_javascript = javascript;
		}

		protected String getName() {
			return _name;
		}

		protected String getJavascript() {
			return _javascript;
		}

		protected Class<T> getType() {
			return _type;
		}
	}

	protected static <T> Parameter<T> of(String name, Class<T> type, String javascript) {
		return new Parameter<T>(name, type, javascript);
	}

	protected static class ParameterMap {

		Map<String, Object> _map;

		protected ParameterMap(Map<String, Object> map) {
			_map = map;
		}

		public <T> T getValue(Parameter<T> parameter) {
			return (T) _map.get(parameter.getName());
		}
	}

	public final AbstractParameterizedDefaultAjaxBehavior setThrottleDelay(Duration throttleDelay) {
		_throttleDelay = throttleDelay;
		return this;
	}

	protected abstract void respond(AjaxRequestTarget target, ParameterMap parameterMap);

	protected abstract Parameter<?>[] getParameter();

}
