/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

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

	protected static class AjaxEventVisitor implements IVisitor<Component,Void> {

		AbstractAjaxEvent _event;

		protected AjaxEventVisitor(AbstractAjaxEvent event) {
			_event = event;
		}
		
		@Override
		public void component(Component component, IVisit<Void> visit) {
			//			if (component instanceof AjaxEventListenerInterface)
			//			{
			((AjaxEventListenerInterface) component).notifyAjaxEvent(_event);
			//			}
		}
	}

}
