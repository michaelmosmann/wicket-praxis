package de.wicketpraxis.web.blog.pages.questions.ajax.javascript;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.model.IModel;

public class OnClickAlert extends AttributeAppender {

	public OnClickAlert(IModel<String> text) {
		super("onclick", new WrapStringModel("onClickAlert('", text, "')"), ";");
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(JavaScriptHeaderItem.forScript("function onClickAlert(text)\n {\n alert(text);\n }\n", getClass().getName()));
	}
}
