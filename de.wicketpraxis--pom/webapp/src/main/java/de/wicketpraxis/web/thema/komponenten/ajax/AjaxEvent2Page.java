/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

import java.util.Date;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class AjaxEvent2Page extends WebPage
{
	private Label _message;
	
	public AjaxEvent2Page()
	{
		AjaxEventListener<Event> event = new AjaxEventListener<Event>("event",Event.class)
		{
			@Override
			protected boolean onAjaxEvent(Event event)
			{
				_message.setDefaultModelObject(event.getMessage());
				return true;
			}
		};
		_message = new Label("message","Text"); 
		event.add(_message);
		add(event);
		
		add(new AjaxLink("link")
		{
			@Override
			public void onClick(AjaxRequestTarget target)
			{
				new Event(this,target,"Link geklickt ("+new Date()+")").fire();
			}
		});

	}
	
	static class Event extends AbstractAjaxEvent
	{
		String _message;
		
		protected Event(Component source, AjaxRequestTarget requestTarget,String message)
		{
			super(source, requestTarget);
			_message=message;
		}
		
		public String getMessage()
		{
			return _message;
		}
	}

}
