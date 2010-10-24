/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class CustomValidatorPage extends AbstractFormPage
{
	public CustomValidatorPage()
	{
		Form form=new Form("form");
		
		getFeedbackPanel().setEscapeModelStrings(false);
		
		form.add(new TextField<String>("Palindrom",Model.of("")).add(new PalindromValidator()));
		
		add(form);
	}
	
	public static class PalindromValidator extends AbstractValidator<String>
	{
		@Override
		protected void onValidate(IValidatable<String> validatable)
		{
			String value = validatable.getValue().toLowerCase();
			String reverse=new StringBuilder(value).reverse().toString();
			
			int index=-1;
			for (int i=0;i<value.length();i++)
			{
				if (value.charAt(i)!=reverse.charAt(i))
				{
					index=i;
					break;
				}
			}
			if (index>=0)
			{
				Map<String,Object> vars=new HashMap<String, Object>();
				vars.put("index", index);
				vars.put("reverse", reverse);
				if (index>0)
				{
					vars.put("part", value.substring(0,index));
					vars.put("leftInput", value.substring(index));
					vars.put("leftReverse", reverse.substring(index));
					error(validatable,"Partial",vars);
				}
				else
				{
					error(validatable,"NoMatch",vars);
				}
			}
		}
	}
}
