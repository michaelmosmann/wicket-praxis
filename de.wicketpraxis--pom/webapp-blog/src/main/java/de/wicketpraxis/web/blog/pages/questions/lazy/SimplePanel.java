package de.wicketpraxis.web.blog.pages.questions.lazy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class SimplePanel extends Panel
{
	public SimplePanel(String id)
	{
		super(id);
		
		Model<Integer> countModel = Model.of(1);
		
		add(new Link<Integer>("link",countModel)
		{
			@Override
			public void onClick()
			{
				setModelObject(getModelObject()+1);
			}
		});
		
		add(new Label("label",countModel));
	}

}
