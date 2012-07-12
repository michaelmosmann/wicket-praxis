package de.wicketpraxis.web.blog.pages.questions.migration.forms;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ResultPage extends WebPage {

	public ResultPage(String name) {
		init(name);
	}

	public ResultPage(PageParameters pageParameters) {
		init(pageParameters.get("Name").toString());
	}

	protected void init(String name) {
		add(new Label("name", name));
	}
}
