package de.wicketpraxis.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.events.AbstractEvent;
import de.wicketpraxis.events.Events;
import de.wicketpraxis.events.GetCurrentCounterEvent;
import de.wicketpraxis.events.ChangeCounterEvent;
import de.wicketpraxis.events.SetCounterEvent;


public class CounterPanel extends Panel {

	Model<Integer> counterModel = Model.of(0);
	Label label;
	
	public CounterPanel(String id) {
		super(id);
		
		label = new Label("counter",counterModel);
		label.setOutputMarkupId(true);
		
		add(label);
	}

	@Override
	public void onEvent(IEvent<?> event) {
		
		AbstractEvent<?,?> e=Events.asEvent(event);
		
		if (e instanceof SetCounterEvent) {
			SetCounterEvent sk=(SetCounterEvent) e;
			Integer lastValue = counterModel.getObject();
			counterModel.setObject(sk.getNewCounter());
			sk.respondWith(lastValue);
			sk.update(label);
			
			System.out.println("Path: "+sk.asPath());
		}
		
		if (e instanceof GetCurrentCounterEvent) {
			GetCurrentCounterEvent cc=(GetCurrentCounterEvent) e;
			cc.respondWith(counterModel.getObject());
			
			System.out.println("Path: "+cc.asPath());
		}
		
		
	}
}
