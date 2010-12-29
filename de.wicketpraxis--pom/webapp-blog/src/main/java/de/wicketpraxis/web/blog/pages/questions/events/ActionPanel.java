package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class ActionPanel extends Panel {

	public ActionPanel(String id, IModel<Integer> change) {
		super(id);

		AjaxFallbackLink<Integer> link = new AjaxFallbackLink<Integer>("link", change) {

			@Override
			public void onClick(AjaxRequestTarget target) {
				new ChangeEvent(ActionPanel.this, target, getModelObject()).fire();
			}
		};
		link.add(new Label("change", change));
		add(link);
	}

}
