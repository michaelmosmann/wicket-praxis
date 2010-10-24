package de.wicketpraxis.web.blog.pages.questions.email;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.BaseWicketTester;

public class EmailFromComponentPage extends WebPage
{
	public EmailFromComponentPage()
	{
		WicketCallback<List<String>, String> callback = new WicketCallback<List<String>, String>()
		{
			public String getResult(List<String> input)
			{
				final IModel<List<? extends String>> listModel = Model.ofList(input);
				
				BaseWicketTester tester=new BaseWicketTester();
				tester.startPage(new EmailContentPage(listModel));
				return tester.getServletResponse().getDocument();
			}
		};
		
		String result;
		try
		{
			result = WicketThreadAdapter.getResult(callback, Arrays.asList("Klaus","Susi","Bert"));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			result=e.getLocalizedMessage();
		}
		
		add(new Label("email",result).setEscapeModelStrings(false));
	}
}
