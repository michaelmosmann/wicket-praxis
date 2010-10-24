/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import java.io.Serializable;
import java.text.MessageFormat;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.model.CompoundPropertyModel;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.LoginBean;

@TitleAnnotation(title="Form Validator",space=true)
public class FormValidatorPage extends AbstractFormPage
{
	public FormValidatorPage()
	{
		Form<LoginBean> form=new Form<LoginBean>("form",new CompoundPropertyModel<LoginBean>(new LoginBean()))
		{
			@Override
			protected void onSubmit()
			{
				LoginBean bean = getModelObject();
				info("Passwort: "+bean.getPassword()+", Passwort2: "+bean.getPassword2());
			}
		};
		
		PasswordTextField passwordTextField = new PasswordTextField("Password");
		form.add(passwordTextField);
		PasswordTextField passwordTextField2 = new PasswordTextField("Password2");
		form.add(passwordTextField2);
		
//		form.add(new EqualInputValidator(passwordTextField,passwordTextField2));
		form.add(new EqualPasswordInputValidator(passwordTextField,passwordTextField2));
		add(form);
	}
}
