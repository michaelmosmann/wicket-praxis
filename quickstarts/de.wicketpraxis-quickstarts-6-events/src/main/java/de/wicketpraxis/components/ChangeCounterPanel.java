package de.wicketpraxis.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.events.Events;
import de.wicketpraxis.events.ChangeCounterEvent;


public class ChangeCounterPanel extends Panel {

	public ChangeCounterPanel(String id, final int change) {
		super(id);
		
		AjaxLink<Void> link = new AjaxLink<Void>("link") {
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				Integer newCounter=new ChangeCounterEvent(Events.from(this,target),change).send();
				System.out.println("New Counter: "+newCounter);
			}
		};
		link.add(new Label("value",Model.of(change)));
		add(link);
	}

}
