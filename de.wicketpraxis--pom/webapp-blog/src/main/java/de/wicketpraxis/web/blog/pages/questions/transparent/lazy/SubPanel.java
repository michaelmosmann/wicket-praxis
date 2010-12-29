package de.wicketpraxis.web.blog.pages.questions.transparent.lazy;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class SubPanel extends BasePanel {

	public SubPanel(String id) {
		super(id);
	}

	@Override
	protected MarkupContainer lazyInit() {
		MarkupContainer root = super.lazyInit();
		root.add(new Label("label", Model.of("Sub")));
		return root;
	}
}
