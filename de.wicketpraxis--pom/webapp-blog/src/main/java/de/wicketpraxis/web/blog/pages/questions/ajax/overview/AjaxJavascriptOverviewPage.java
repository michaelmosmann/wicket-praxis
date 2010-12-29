package de.wicketpraxis.web.blog.pages.questions.ajax.overview;

import org.apache.wicket.markup.html.WebPage;

public class AjaxJavascriptOverviewPage extends WebPage {

	public AjaxJavascriptOverviewPage() {
		add(new MousePosPanel("mouse"));
	}
}
