package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class CounterPanel extends Panel implements EventListenerInterface {

	IModel<Integer> _counter;

	public CounterPanel(String id, IModel<Integer> counter) {
		super(id);

		setOutputMarkupId(true);

		_counter = counter;

		add(new Label("counter", _counter));
	}

	public void notifyEvent(AbstractEvent event) {
		if (event instanceof ChangeEvent) {
			int change = ((ChangeEvent) event).getChange();
			Integer cur = _counter.getObject();

			info("Aktuell: " + cur + " Change: " + change);

			_counter.setObject(cur + change);
			event.update(this);
		}
	}
}
