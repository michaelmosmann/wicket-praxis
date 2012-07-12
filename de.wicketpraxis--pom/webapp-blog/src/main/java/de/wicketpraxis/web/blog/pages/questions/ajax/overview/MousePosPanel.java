package de.wicketpraxis.web.blog.pages.questions.ajax.overview;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class MousePosPanel extends Panel {

	public MousePosPanel(String id) {
		super(id);

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		WebMarkupContainer box = new WebMarkupContainer("box");
		box.add(new AjaxEventBehavior("onclick") {

			@Override
			protected void onEvent(AjaxRequestTarget target) {
//				PageParameters pageParameters = RequestCycle.get().getPageParameters();
				PageParameters pageParameters = target.getPageParameters();
				info("geklickt: " + pageParameters);
				target.addComponent(feedbackPanel);
			}
		});
		add(box);
	}

}
