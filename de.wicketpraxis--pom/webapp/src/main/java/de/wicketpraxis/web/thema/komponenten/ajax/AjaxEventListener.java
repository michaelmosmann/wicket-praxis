/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

import org.apache.wicket.markup.html.WebMarkupContainer;

public class AjaxEventListener<T extends AbstractAjaxEvent> extends WebMarkupContainer implements
		AjaxEventListenerInterface {

	Class<? extends T> _eventType;

	protected AjaxEventListener(String id, Class<? extends T> eventType) {
		super(id);
		setOutputMarkupPlaceholderTag(true);
		_eventType = eventType;
	}

	public void notifyAjaxEvent(AbstractAjaxEvent event) {
		if (_eventType.isInstance(event)) {
			ajaxEvent((T) event);
		}
	}

	protected void ajaxEvent(T event) {
		if (onAjaxEvent(event))
			event.update(this);
	}

	protected boolean onAjaxEvent(T event) {
		return true;
	}
}
