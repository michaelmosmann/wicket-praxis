/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.feedback;

import org.apache.wicket.Session;
import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.feedback.IFeedback;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.border.Border;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormComponentCssFeedbackBorder extends Border implements IFeedback {

	private static final Logger _logger = LoggerFactory.getLogger(FormComponentCssFeedbackBorder.class);

	boolean _hasErrors;
	private CharSequence _cssClass;

	public FormComponentCssFeedbackBorder(String id, String cssClass) {
		super(id);
		_cssClass = cssClass;
	}

	/**
	 * Update the 'visible' flag to indicate the existence (or lack thereof) of feedback messages
	 */
	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();
		// Get the messages for the current page
		_hasErrors = Session.get().getFeedbackMessages().messages(getMessagesFilter()).size() != 0;
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		if (_hasErrors)
			tag.put("class", _cssClass);
	}

	/**
	 * @return Let subclass specify some other filter
	 */
	protected IFeedbackMessageFilter getMessagesFilter() {
		return new ContainerFeedbackMessageFilter(this);
	}
}
