package de.wicketpraxis.web.blog.pages.questions.ajax.javascript;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class JavascriptAjaxHeadContributorPage extends WebPage {

	public JavascriptAjaxHeadContributorPage() {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);

		final WebMarkupContainer ajaxBorder = new WebMarkupContainer("ajaxBorder");
		ajaxBorder.setOutputMarkupPlaceholderTag(true);
		ajaxBorder.setVisible(false);

		Label toClick = new Label("toClick", "Klick mich");
		toClick.add(new OnClickAlert(Model.of("Variante1")));
		ajaxBorder.add(toClick);

		add(ajaxBorder);

		add(new AjaxLink<Void>("switch") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				ajaxBorder.setVisible(!ajaxBorder.isVisible());
				target.add(ajaxBorder);
			}
		});
	}
}
