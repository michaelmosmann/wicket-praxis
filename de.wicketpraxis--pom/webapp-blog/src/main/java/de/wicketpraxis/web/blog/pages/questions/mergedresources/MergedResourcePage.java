package de.wicketpraxis.web.blog.pages.questions.mergedresources;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;


@Deprecated
public class MergedResourcePage extends WebPage {
	
	public MergedResourcePage(PageParameters pageParameters) {
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderCSSReference(new PackageResourceReference(getClass(), "partOne.css"));
		response.renderCSSReference(new PackageResourceReference(getClass(), "partTwo.css"));
	}
}
