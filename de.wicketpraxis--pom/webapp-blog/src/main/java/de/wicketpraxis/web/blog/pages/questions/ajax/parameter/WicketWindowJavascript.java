package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class WicketWindowJavascript {

	private WicketWindowJavascript() {
	}

	public static final ResourceReference RESOURCE = new PackageResourceReference(WicketWindowJavascript.class,
			"WicketWindowJavascript.js");
}
