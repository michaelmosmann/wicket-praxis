package de.wicketpraxis.web.blog.pages.questions.mergedresources;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;


public class MergedResourcePage extends WebPage {
	
	public MergedResourcePage(PageParameters pageParameters) {
		add(CSSPackageResource.getHeaderContribution(getClass(), "partOne.css"));
		add(CSSPackageResource.getHeaderContribution(getClass(), "partTwo.css"));
	}
}
