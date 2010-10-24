package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.Component;
import org.apache.wicket.Component.IVisitor;

public class NotifyVisitor implements IVisitor<Component> 
{
	private final AbstractEvent _event;
	 
	public NotifyVisitor(final AbstractEvent event)
	{
		_event = event;
	}
	 
	public Object component(final Component component)
	{
		if (component instanceof EventListenerInterface) 
		{
			((EventListenerInterface) component).notifyEvent(_event);
		}
		return IVisitor.CONTINUE_TRAVERSAL;
	}
}
