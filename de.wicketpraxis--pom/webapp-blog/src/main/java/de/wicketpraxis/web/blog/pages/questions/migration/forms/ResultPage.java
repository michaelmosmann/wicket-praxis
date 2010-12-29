package de.wicketpraxis.web.blog.pages.questions.migration.forms;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ResultPage extends WebPage {

	public ResultPage(String name) {
		init(name);
	}

	public ResultPage(PageParameters pageParameters) {
		init(pageParameters.getString("Name"));
	}

	protected void init(String name) {
		add(new Label("name", name));
	}
}
