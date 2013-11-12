package de.wicketpraxis.usecase.replacements;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class HiddenComponentPage extends WebPage {

	private static final String WICKET_COMP_ID = "label";

	Label labelA = new Label(WICKET_COMP_ID,Model.of("A"));
	Label labelB = new Label(WICKET_COMP_ID,Model.of("B"));
	
	public HiddenComponentPage() {

		add(labelA);
		add(new Link<Void>("link") {
			@Override
			public void onClick() {
				HiddenComponentPage.this.replace(labelB);
			}
		});
		setStatelessHint(false);
	}

}
