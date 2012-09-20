package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class ParameterizedAjaxPage extends WebPage {

	public ParameterizedAjaxPage() {
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		WebMarkupContainer block = new WebMarkupContainer("block");
		block.add(new PageMouseClickBehavior() {

			@Override
			protected void onClick(AjaxRequestTarget target, int x, int y) {
				info("Clicked: " + x + "," + y);
				target.add(feedbackPanel);
			}
		});
		add(block);
	}
}
