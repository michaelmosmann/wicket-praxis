/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.replace;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(space = true, title = "Component Replace")
public class ComponentReplacePage extends WebPage {

	public ComponentReplacePage() {
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		add(new AjaxFallbackConfirmLink<String>("link", Model.of("löschen?")) {

			@Override
			public void onConfirm(AjaxRequestTarget target) {
				if (target != null)
					target.addComponent(feedbackPanel);
				info("Ok. Dann mach ich's");
			}

			@Override
			public void onCancel(AjaxRequestTarget target) {
				if (target != null)
					target.addComponent(feedbackPanel);
				error("Ok. Besser nicht.");
			}
		});
	}
}
