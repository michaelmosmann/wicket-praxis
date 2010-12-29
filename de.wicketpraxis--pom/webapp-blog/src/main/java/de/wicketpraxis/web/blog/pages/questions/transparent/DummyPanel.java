package de.wicketpraxis.web.blog.pages.questions.transparent;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class DummyPanel extends Panel {

	public DummyPanel(String id) {
		super(id);

		add(new Link<Void>("link") {

			@Override
			public void onClick() {

			}
		});
	}

}
