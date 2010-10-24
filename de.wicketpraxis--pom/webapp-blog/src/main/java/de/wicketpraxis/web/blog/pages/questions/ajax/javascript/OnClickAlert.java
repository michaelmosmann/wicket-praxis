package de.wicketpraxis.web.blog.pages.questions.ajax.javascript;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.model.IModel;

public class OnClickAlert extends AttributeAppender
{
	public OnClickAlert(IModel<String> text)
	{
		super("onclick", true, new WrapStringModel("onClickAlert('",text,"')"), ";");
	}
	
	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		
		response.renderJavascript("function onClickAlert(text)\n {\n alert(text);\n }\n", getClass().getName());
	}
}
