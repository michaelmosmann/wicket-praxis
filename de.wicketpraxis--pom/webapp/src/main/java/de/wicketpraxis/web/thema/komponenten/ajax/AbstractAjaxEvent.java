/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.Component.IVisitor;
import org.apache.wicket.ajax.AjaxRequestTarget;

public abstract class AbstractAjaxEvent {

	Component _source;
	AjaxRequestTarget _requestTarget;

	protected AbstractAjaxEvent(Component source, AjaxRequestTarget requestTarget) {
		_source = source;
		_requestTarget = requestTarget;
	}

	public Component getSource() {
		return _source;
	}

	public void fire() {
		_source.getPage().visitChildren(AjaxEventListenerInterface.class, new AjaxEventVisitor(this));
	}

	public void update(Component component) {
		_requestTarget.addComponent(component);
	}

	protected static class AjaxEventVisitor implements IVisitor<Component> {

		AbstractAjaxEvent _event;

		protected AjaxEventVisitor(AbstractAjaxEvent event) {
			_event = event;
		}

		public Object component(Component component) {
			//			if (component instanceof AjaxEventListenerInterface)
			//			{
			((AjaxEventListenerInterface) component).notifyAjaxEvent(_event);
			//			}
			return IVisitor.CONTINUE_TRAVERSAL;
		}
	}

}
