package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.Component;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

public class NotifyVisitor implements IVisitor<Component,Void> {

	private final AbstractEvent _event;

	public NotifyVisitor(final AbstractEvent event) {
		_event = event;
	}
	
	@Override
	public void component(Component component, IVisit<Void> visit) {
		if (component instanceof EventListenerInterface) {
			((EventListenerInterface) component).notifyEvent(_event);
		}
	}

}
