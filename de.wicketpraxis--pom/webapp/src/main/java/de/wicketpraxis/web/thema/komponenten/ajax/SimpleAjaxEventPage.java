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

public class SimpleAjaxEventPage extends WebPage
{
	public SimpleAjaxEventPage()
	{
		add(new EventLabel("message","Text"));
		add(new AjaxLink("link")
		{
			@Override
			public void onClick(AjaxRequestTarget target)
			{
				new SomeEvent(this,target).fire();
			}
		});
	}
	
	static class EventLabel extends Label implements AjaxEventListenerInterface
	{
		public EventLabel(String id, String label)
		{
			super(id, label);
			setOutputMarkupId(true);
		}

		public void notifyAjaxEvent(AbstractAjaxEvent event)
		{
			if (event instanceof SomeEvent)
			{
				setDefaultModelObject("Event ausgelöst durch "+event.getSource().getId()+"("+new Date()+")");
				event.update(this);
			}
		}
	}
	
	static class SomeEvent extends AbstractAjaxEvent
	{
		protected SomeEvent(Component source, AjaxRequestTarget requestTarget)
		{
			super(source, requestTarget);
		}
	}
}
