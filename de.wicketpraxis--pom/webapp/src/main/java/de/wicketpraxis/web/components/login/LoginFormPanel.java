/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.components.login;

import java.io.Serializable;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.components.AbstractOnlyPublicPanel;
import de.wicketpraxis.web.session.WicketPraxisSession;
import de.wicketpraxis.web.validators.UserLoginValidator;

public class LoginFormPanel extends AbstractOnlyPublicPanel
{
	private static final Logger _logger = LoggerFactory.getLogger(LoginFormPanel.class);
	
	private LoginData _loginData;
	
	@SpringBean(name=UserDao.BEAN_ID)
	UserDao _userDao;
	
	public LoginFormPanel(String id)
	{
		super(id);
		
		_loginData = new LoginData();
		Form<LoginData> form=new Form<LoginData>("form",new CompoundPropertyModel<LoginData>(_loginData))
		{
			@Override
			protected void onSubmit()
			{
				User user = _userDao.getByEMail(_loginData.getEMail());
				if (user!=null)
				{
					WicketPraxisSession.get().setUser(user);
					setResponsePage(WicketPraxisApplication.get().getUserHomePage());
				}
				else
				{
					error("User not found. Should not happen");
				}
			}
		};
		
		final TextField<String> emailTextField = new TextField<String>("EMail");
		emailTextField.setRequired(true);
		final PasswordTextField passwordTextField = new PasswordTextField("Password");
		
//		FormComponentFeedbackIndicator fehlerEmail=new FormComponentFeedbackIndicator("fehlerEmail");
//		fehlerEmail.setIndicatorFor(emailTextField);
//		add(fehlerEmail);
		
		ComponentFeedbackPanel fehlerEmail=new ComponentFeedbackPanel("EMail.Fehler",emailTextField);
		form.add(fehlerEmail);
		
		ComponentFeedbackPanel fehlerPassword=new ComponentFeedbackPanel("Password.Fehler",passwordTextField);
		form.add(fehlerPassword);
		
		form.add(emailTextField);
		form.add(passwordTextField);
		
		form.add(new Button("submit"));
		
//		IFormValidator validator=new AbstractFormValidator()
//		{
//			public FormComponent<?>[] getDependentFormComponents()
//			{
//				// TODO Auto-generated method stub
//				return new FormComponent[]{emailTextField,passwordTextField};
//			}
//			
//			public void validate(Form<?> form)
//			{
//				String email=emailTextField.getInput();
//				String pass=passwordTextField.getInput();
//				
//				
//				User user = _userDao.getByEMail(email);
//				if (user!=null)
//				{
//					if (!user.isPasswordValid(pass))
//					{
//						error(passwordTextField,"Invalid");
//					}
//				}
//				else error(emailTextField,"NotFound");
//			}
//		};
		
//		form.add(validator);
		form.add(new UserLoginValidator(_userDao,emailTextField,passwordTextField));
		
		add(form);
		
		FeedbackPanel feedbackPanel=new FeedbackPanel("feedback",new ContainerFeedbackMessageFilter(form));
		
		add(feedbackPanel);
	}
	
	public static class LoginData implements Serializable
	{
		String _eMail;
		
		String _password;

		public String getEMail()
		{
			return _eMail;
		}

		public void setEMail(String mail)
		{
			_eMail = mail;
		}

		public String getPassword()
		{
			return _password;
		}

		public void setPassword(String password)
		{
			_password = password;
		}
	}
}
