package de.wicketpraxis.web.blog.pages.questions.transparent;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AbstractBasePanel extends Panel {

	private WebMarkupContainer _border;

	public AbstractBasePanel(String id) {
		super(id);

		_border = new WebMarkupContainer("border");
		_border.setOutputMarkupPlaceholderTag(true);
		add(_border);
	}

	public void hide(AjaxRequestTarget target) {
		_border.setVisible(false);
		if (target != null)
			target.add(_border);
	}

	public void show(AjaxRequestTarget target) {
		_border.setVisible(true);
		if (target != null)
			target.add(_border);
	}
}
