package de.wicketpraxis.web.blog.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.blog.pages.examples.models.pagination.ModelPaginationPage;


public class BlogExamples extends WebPage {

	
	public BlogExamples() {
		List<Class<? extends WebPage>> pages = new ArrayList<Class<? extends WebPage>>();
		
		pages.add(ModelPaginationPage.class);

		add(new PageLinksPanel("list",pages));
	}
}
