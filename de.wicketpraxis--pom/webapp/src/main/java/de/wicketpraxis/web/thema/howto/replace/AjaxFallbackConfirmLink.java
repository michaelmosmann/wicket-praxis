/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.replace;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AjaxFallbackConfirmLink<T> extends AjaxFallbackLink<T> {

	IModel<String> _message;

	public AjaxFallbackConfirmLink(String id, IModel<String> message) {
		super(id);
		_message = message;
		setOutputMarkupId(true);
	}

	public AjaxFallbackConfirmLink(String id, IModel<T> model, IModel<String> message) {
		super(id, model);
		_message = message;
		setOutputMarkupId(true);
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		ConfirmPanel confirmLink = new ConfirmPanel(this);

		if (target != null)
			target.add(confirmLink);
	}

	class ConfirmPanel extends Panel {

		AjaxFallbackLink<T> _parent;

		public ConfirmPanel(AjaxFallbackLink<T> parent) {
			super(parent.getId());
			_parent = parent;
			setOutputMarkupId(true);

			add(new Label("message", _message));

			add(new AjaxFallbackLink<T>("yes", parent.getModel()) {

				@Override
				public void onClick(AjaxRequestTarget target) {
					ConfirmPanel.this.replaceWith(_parent);
					if (target != null)
						target.add(_parent);
					onConfirm(target);
				}
			});

			add(new AjaxFallbackLink<T>("no", parent.getModel()) {

				@Override
				public void onClick(AjaxRequestTarget target) {
					ConfirmPanel.this.replaceWith(_parent);
					if (target != null)
						target.add(_parent);
					onCancel(target);
				}
			});

			parent.replaceWith(this);
		}

		@Override
		protected void onComponentTag(ComponentTag tag) {
			super.onComponentTag(tag);
			// link in link korrigiert firefox, so dass ajaxReplace nicht korrekt funktioniert
			// wir entschärfen das Markup, was da benutzt wird zu einem span
			tag.setName("span");
		}
	}

	public abstract void onConfirm(AjaxRequestTarget target);

	public void onCancel(AjaxRequestTarget target) {

	}
}
