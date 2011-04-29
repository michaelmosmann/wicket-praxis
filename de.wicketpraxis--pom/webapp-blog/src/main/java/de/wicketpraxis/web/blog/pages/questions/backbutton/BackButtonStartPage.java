package de.wicketpraxis.web.blog.pages.questions.backbutton;

import org.apache.wicket.markup.html.WebPage;

public class BackButtonStartPage extends WebPage {

	public BackButtonStartPage() {
		setResponsePage(new BackButtonPage());
		setRedirect(true);
	}
}
