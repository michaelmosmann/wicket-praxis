package de.wicketpraxis.components;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import de.wicketpraxis.events.Events;
import de.wicketpraxis.events.ResetCounterEvent;

public class ResetCounterPanel extends Panel {

	public ResetCounterPanel(String id) {
		super(id);

		add(new Link<Void>("link") {

			@Override
			public void onClick() {
				System.out.println("Reset to: " + new ResetCounterEvent(Events.from(this)).send());
			}
		});
	}

}
