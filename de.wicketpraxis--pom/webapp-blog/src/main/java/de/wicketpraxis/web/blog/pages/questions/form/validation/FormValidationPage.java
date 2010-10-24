package de.wicketpraxis.web.blog.pages.questions.form.validation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.IValidationError;
import org.apache.wicket.validation.ValidationError;

public class FormValidationPage extends WebPage
{
	public FormValidationPage()
	{
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		final TextField<Integer> inputA = new TextField<Integer>("a");
		final TextField<Integer> inputB = new TextField<Integer>("b");
		inputA.setRequired(true);
		inputB.setRequired(true);
		
		CompoundPropertyModel<FormBean> formModel = new CompoundPropertyModel<FormBean>(new FormBean());
		Form<FormBean> form = new Form<FormBean>("form",formModel)
		{
			@Override
			protected void onValidate()
			{
				if ((!inputA.hasErrorMessage()) && (!inputB.hasErrorMessage()))
				{					
					Integer a=inputA.getConvertedInput();
					Integer b=inputB.getConvertedInput();
					if (a<b)
					{
						ValidationError error = new ValidationError();
						error.addMessageKey("compare");
						error.setVariable("a", a);
						error.setVariable("b", b);
						
						inputA.error((IValidationError) error);
					}
				}
			}
			
			@Override
			protected void onSubmit()
			{
				info("onSubmit");
			}
		};
		
		form.add(inputA);
		form.add(inputB);
		
		add(form);
	}
}
