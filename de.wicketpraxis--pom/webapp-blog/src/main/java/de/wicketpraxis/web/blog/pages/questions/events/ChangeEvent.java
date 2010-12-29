package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class ChangeEvent extends AbstractEvent {

	int _change;

	protected ChangeEvent(Component source, AjaxRequestTarget requestTarget, int change) {
		super(source, requestTarget);

		_change = change;
	}

	public int getChange() {
		return _change;
	}
}
