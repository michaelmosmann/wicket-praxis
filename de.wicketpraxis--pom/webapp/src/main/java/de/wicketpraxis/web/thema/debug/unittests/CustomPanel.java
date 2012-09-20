/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug.unittests;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

public class CustomPanel extends Panel {

	public CustomPanel(String id) {
		super(id);

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);

		add(feedbackPanel);

		add(new AjaxFallbackLink("link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {
					info("Link per Ajax");
					target.add(feedbackPanel);
				} else {
					info("Link ohne Ajax");
				}
			}
		});
	}

}
