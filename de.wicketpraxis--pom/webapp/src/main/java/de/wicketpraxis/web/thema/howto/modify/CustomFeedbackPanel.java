/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.modify;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class CustomFeedbackPanel extends FeedbackPanel {

	public CustomFeedbackPanel(String id) {
		super(id);
	}

	public CustomFeedbackPanel(String id, IFeedbackMessageFilter filter) {
		super(id, filter);
	}

	@Override
	protected String getCSSClass(FeedbackMessage message) {
		return message.getLevelAsString().toLowerCase();
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderCSSReference(new PackageResourceReference(CustomFeedbackPanel.class, "feedback.css"));
	}
}
