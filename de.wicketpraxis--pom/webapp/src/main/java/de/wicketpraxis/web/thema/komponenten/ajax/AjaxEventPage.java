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

public class AjaxEventPage extends WebPage
{
	private Label _someLabel;

	public AjaxEventPage()
	{
		AjaxEventListener<Event> event = new AjaxEventListener<Event>("event",Event.class);
		_someLabel = new Label("message","Text"); 
		event.add(_someLabel);
		add(event);
		
		add(new AjaxLink("link")
		{
			@Override
			public void onClick(AjaxRequestTarget target)
			{
				_someLabel.setDefaultModelObject("Link geklickt ("+new Date()+")");
				new Event(this,target).fire();
			}
		});
	}
	
	static class Event extends AbstractAjaxEvent
	{
		protected Event(Component source, AjaxRequestTarget requestTarget)
		{
			super(source, requestTarget);
		}
	}
	
}
