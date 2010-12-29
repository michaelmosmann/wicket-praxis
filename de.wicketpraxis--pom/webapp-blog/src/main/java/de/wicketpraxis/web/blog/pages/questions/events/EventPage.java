package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class EventPage extends WebPage {

	public EventPage() {
		add(new EventFeedbackPanel("feedback"));

		add(new ActionPanel("changeAdd1", Model.of(1)));
		add(new ActionPanel("changeSub1", Model.of(-1)));

		add(new CounterPanel("counter", Model.of(5)));
	}

	static class EventFeedbackPanel extends FeedbackPanel implements EventListenerInterface {

		public EventFeedbackPanel(String id) {
			super(id);

			setOutputMarkupId(true);
		}

		public void notifyEvent(AbstractEvent event) {
			event.update(this);
		}
	}
}
