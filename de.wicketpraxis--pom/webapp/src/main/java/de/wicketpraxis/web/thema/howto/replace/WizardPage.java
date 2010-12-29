/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.replace;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class WizardPage extends WebPage {

	public WizardPage() {
		add(new FeedbackPanel("feedback"));

		final String wid = "panel";

		final List<WizardPanel> list = Arrays.asList(new WizardPanel(wid, 1), new WizardPanel(wid, 2), new WizardPanel(wid,
				3));

		add(list.get(0));

		add(new Link("next") {

			@Override
			public void onClick() {
				Component curPage = WizardPage.this.get(wid);
				int idx = list.indexOf(curPage);
				idx++;
				if (idx >= list.size())
					idx = 0;
				curPage.replaceWith(list.get(idx));
			}
		});
	}

	class WizardPanel extends Panel {

		public WizardPanel(String id, int start) {
			super(id);

			Model<Integer> model = Model.of(start);

			Form<Integer> form = new Form<Integer>("form");
			form.add(new TextField<Integer>("zahl", model).setRequired(true));
			add(form);

			add(new Label("zahl", model));
		}

	}
}
