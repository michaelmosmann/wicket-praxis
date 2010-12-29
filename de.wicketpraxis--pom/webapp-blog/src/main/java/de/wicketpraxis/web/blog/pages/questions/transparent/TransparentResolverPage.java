package de.wicketpraxis.web.blog.pages.questions.transparent;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

public class TransparentResolverPage extends WebPage {

	public TransparentResolverPage(PageParameters pageParameters) {
		final ExtendedPanel panel = new ExtendedPanel("panel");

		add(panel);

		// bug?
		// if invisible during startup, errors came up
		if (pageParameters.getAsBoolean("Hide", false))
			panel.hide(null);

		add(new AjaxLink<Void>("on") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				panel.show(target);
			}
		});

		add(new AjaxLink<Void>("off") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				panel.hide(target);
			}
		});
	}
}
