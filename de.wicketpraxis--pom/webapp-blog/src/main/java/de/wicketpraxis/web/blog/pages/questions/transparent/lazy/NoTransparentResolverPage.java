package de.wicketpraxis.web.blog.pages.questions.transparent.lazy;

import org.apache.wicket.markup.html.WebPage;

public class NoTransparentResolverPage extends WebPage
{
	public NoTransparentResolverPage()
	{
		add(new SubPanel("panel"));
	}
}
