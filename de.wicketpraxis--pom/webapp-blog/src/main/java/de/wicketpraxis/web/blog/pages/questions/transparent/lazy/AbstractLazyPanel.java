package de.wicketpraxis.web.blog.pages.questions.transparent.lazy;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AbstractLazyPanel extends Panel
{
	boolean _lazyInitCalled;
	
	public AbstractLazyPanel(String id)
	{
		super(id);
	}

	@Override
	protected void onBeforeRender()
	{
		if (!_lazyInitCalled)
		{
			_lazyInitCalled=true;
			lazyInit();
		}
		super.onBeforeRender();
	}

	protected abstract MarkupContainer lazyInit();
}
