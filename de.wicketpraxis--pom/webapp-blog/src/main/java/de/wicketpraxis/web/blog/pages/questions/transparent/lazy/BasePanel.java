package de.wicketpraxis.web.blog.pages.questions.transparent.lazy;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;

public abstract class BasePanel extends AbstractLazyPanel
{
	public BasePanel(String id)
	{
		super(id);
	}

	@Override
	protected MarkupContainer lazyInit()
	{
		WebMarkupContainer border = new WebMarkupContainer("border");
		add(border);
		return border;
	}
}
