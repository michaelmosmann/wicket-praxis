package de.wicketpraxis.web.blog.pages.questions.ajax.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AbstractModalClosePanel extends Panel
{
	public AbstractModalClosePanel(ModalWindow modalWindow)
	{
		super(modalWindow.getContentId());
		
		add(new AjaxLink<Void>("link")
		{
			@Override
			public void onClick(AjaxRequestTarget target)
			{
				AbstractModalClosePanel.this.onClick(target);
			}
		});
	}
	
	public abstract void onClick(AjaxRequestTarget target);
}
