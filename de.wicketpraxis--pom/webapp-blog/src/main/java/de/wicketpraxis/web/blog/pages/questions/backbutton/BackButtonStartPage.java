package de.wicketpraxis.web.blog.pages.questions.backbutton;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;

public class BackButtonStartPage extends WebPage {

	public BackButtonStartPage() {
		setResponsePage(new BackButtonPage());
	}
}
