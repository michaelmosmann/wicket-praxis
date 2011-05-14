package de.wicketpraxis.web.blog.pages.questions.ajax.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.IAjaxRegionMarkupIdProvider;
import org.apache.wicket.behavior.AbstractBehavior;


public class AjaxRegionBehavior extends AbstractBehavior implements IAjaxRegionMarkupIdProvider {

	@Override
	public void beforeRender(Component component) {
		component.getResponse().write("<div style=\"border:1px solid red;\" id=\""+getAjaxRegionMarkupId(component)+"\">");
		super.beforeRender(component);
	}
	
	@Override
	public void onRendered(Component component) {
		super.onRendered(component);
		component.getResponse().write("</div>");
	}
	
	@Override
	public String getAjaxRegionMarkupId(Component component) {
		return component.getMarkupId()+"_border";
	}
	
}
