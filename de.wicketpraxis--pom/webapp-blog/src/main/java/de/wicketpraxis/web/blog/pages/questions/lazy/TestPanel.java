package de.wicketpraxis.web.blog.pages.questions.lazy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class TestPanel extends AbstractLazyPanel
{
	public TestPanel(String id)
	{
		super(id);
	}

	@Override
	protected void lazyInit()
	{
		add(new Label("label",Model.of("Label")));
		add(new SimplePanel("panel"));
	}
}
