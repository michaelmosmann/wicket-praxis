package de.wicketpraxis.web.blog.pages.questions.mergedresources;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;


@Deprecated
public class MergedResourcePage extends WebPage {
	
	public MergedResourcePage(PageParameters pageParameters) {
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssReferenceHeaderItem.forReference(new PackageResourceReference(getClass(), "partOne.css")));
		response.render(CssReferenceHeaderItem.forReference(new PackageResourceReference(getClass(), "partTwo.css")));
	}
}
