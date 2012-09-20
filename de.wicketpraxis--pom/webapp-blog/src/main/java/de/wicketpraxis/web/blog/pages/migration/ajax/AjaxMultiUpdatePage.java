package de.wicketpraxis.web.blog.pages.migration.ajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class AjaxMultiUpdatePage extends WebPage {

	public AjaxMultiUpdatePage() {
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);

		// die geschweiften Klammern haben keine Funktion
		// sie sollen nur den Komponentenbaum veranschaulichen
		WebMarkupContainer block = getBlock(feedback, 1);
		{
			WebMarkupContainer block2 = getBlock(feedback, 2);
			{
				WebMarkupContainer block3 = getBlock(feedback, 3);
				block2.add(block3);
			}
			block.add(block2);
		}
		add(block);
	}

	private WebMarkupContainer getBlock(final FeedbackPanel feedback, int start) {
		final WebMarkupContainer block = new WebMarkupContainer("ajaxUpdate");
		block.setOutputMarkupId(true);

		Model<Integer> model = Model.of(start);
		final Label label = new Label("count", model);
		label.setOutputMarkupId(true);
		block.add(label);

		block.add(new AjaxFallbackLink<Integer>("link", model) {

			@Override
			public void onClick(AjaxRequestTarget target) {
				setModelObject(getModelObject() + 1);
				info("Aktualisiere " + getPath());
				if (target != null) {
					target.add(feedback);
					target.add(block);

					// ist nicht nötig
					target.add(label);
				}
			}
		});

		return block;
	}
}
