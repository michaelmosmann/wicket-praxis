package de.wicketpraxis.web.blog.pages.migration.refactor;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.blog.pages.migration.refactor.step1.CalendarPanel;

public class CalendarRefactorPage extends WebPage {

	public CalendarRefactorPage() {
		add(new CalendarPanel("step1", new Date()));
	}
}
