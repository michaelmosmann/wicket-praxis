package de.wicketpraxis.web.blog.pages.questions.lazy;

import org.apache.wicket.markup.html.WebPage;

public class LazyPanelPage extends WebPage {

	public LazyPanelPage() {
		add(new TestPanel("testPanel"));
	}
}
