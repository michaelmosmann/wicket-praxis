package de.wicketpraxis.web.blog.pages.questions.factories;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class BorderPanelFactory implements IComponentFactory<Panel>
{
	private final IComponentFactory<? extends Component> _content;
	private final IModel<String> _style;

	public BorderPanelFactory(IComponentFactory<? extends Component> content, IModel<String> style)
	{
		_content = content;
		_style = style;
	}
	
	public Panel newComponent(String id)
	{
		return new BorderPanel(id, _content, _style);
	}
	
	static class BorderPanel extends Panel
	{
		public BorderPanel(String id,IComponentFactory<? extends Component> content,IModel<String> style)
		{
			super(id);
			
			WebMarkupContainer border=new WebMarkupContainer("border");
			border.add(content.newComponent("content"));
			border.add(new AttributeAppender("style", true, style,";"));
			add(border);
		}
	}
}