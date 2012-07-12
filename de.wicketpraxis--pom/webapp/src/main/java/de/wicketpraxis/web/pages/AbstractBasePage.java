/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.pages;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.PackageResourceGuard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.components.login.LoginFormPanel;
import de.wicketpraxis.web.components.login.UserHasLoginPanel;

public class AbstractBasePage extends WebPage {

	private Model<String> _pageTitleModel;
	private Model<String> _titleModel;

	public AbstractBasePage() {
		_pageTitleModel = Model.of("Wicket Praxis");
		_titleModel = Model.of("Wicket Praxis");

		add(new Label("pageTitle", _pageTitleModel));
		add(new Label("title", _titleModel));
		add(getHeadPanel("head"));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		response.renderCSSReference(new PackageResourceReference(WicketPraxisApplication.class, "layout/css/style.css"));
	}

	public Model<String> getPageTitleModel() {
		return _pageTitleModel;
	}

	protected Panel getHeadPanel(String id) {
		return new HeadPanel(id);
	}

	public static class HeadPanel extends Panel {

		public HeadPanel(String id) {
			super(id);

			add(new LoginFormPanel("login"));
			add(new UserHasLoginPanel("user"));
		}
	}
}
