package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import org.apache.wicket.Response;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AbstractAutoCompleteRenderer;
import org.apache.wicket.markup.html.form.FormComponent;

public class PlzOrtRenderer extends AbstractAutoCompleteRenderer<PlzOrt>
{
	FormComponent<?> _ortInput;
	
	public PlzOrtRenderer(FormComponent<?> ortInput)
	{
		_ortInput=ortInput;
		_ortInput.setOutputMarkupId(true);
	}
	
	@Override
	protected String getTextValue(PlzOrt object)
	{
		return object.getPlz();
	}

	@Override
	protected void renderChoice(PlzOrt object, Response response, String criteria)
	{
		response.write(object.getPlz() + "-" + object.getOrt());
	}
	
	@Override
	protected CharSequence getOnSelectJavascriptExpression(PlzOrt plzort)
	{
		StringBuilder js = new StringBuilder();
		js.append("wicketGet('").append(_ortInput.getMarkupId()).append("').value ='" + plzort.getOrt() + "';");
		js.append("input");
		return js.toString();
	}

}
