/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public abstract class AbstractFormPage extends WebPage {

	private FeedbackPanel _feedbackPanel;

	public AbstractFormPage() {
		add(Forms.getCss());

		_feedbackPanel = new FeedbackPanel("feedback");
		_feedbackPanel.setOutputMarkupId(true);

		add(_feedbackPanel);
	}

	protected FeedbackPanel getFeedbackPanel() {
		return _feedbackPanel;
	}

	protected void updateFeedbackPanel(AjaxRequestTarget target) {
		target.addComponent(_feedbackPanel);
	}
}
