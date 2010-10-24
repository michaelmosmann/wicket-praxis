/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.modify;

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class CustomFeedbackPanel extends FeedbackPanel
{
	public CustomFeedbackPanel(String id)
	{
		super(id);
		
		add(CSSPackageResource.getHeaderContribution(CustomFeedbackPanel.class,"feedback.css"));
	}
	
	public CustomFeedbackPanel(String id, IFeedbackMessageFilter filter)
	{
		super(id, filter);
		
		add(CSSPackageResource.getHeaderContribution(CustomFeedbackPanel.class,"feedback.css"));
	}
	
	@Override
	protected String getCSSClass(FeedbackMessage message)
	{
		return message.getLevelAsString().toLowerCase();
	}
}
