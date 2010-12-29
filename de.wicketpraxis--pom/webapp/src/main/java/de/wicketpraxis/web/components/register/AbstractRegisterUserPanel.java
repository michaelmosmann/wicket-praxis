/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.components.register;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.validators.UserNotExistValidator;

public abstract class AbstractRegisterUserPanel extends Panel {

	RegisterData _registerData;

	@SpringBean(name = UserDao.BEAN_ID)
	UserDao _userDao;

	public AbstractRegisterUserPanel(String id) {
		super(id);

		_registerData = new RegisterData();

		Form<RegisterData> form = new Form<RegisterData>("form", new CompoundPropertyModel<RegisterData>(_registerData)) {

			@Override
			protected void onSubmit() {
				User newUser = new User();
				newUser.setEMail(_registerData.getEMail());
				newUser.setPassword(_registerData.getPassword());
				_userDao.save(newUser);

				onRegisteredUser(newUser);
			}
		};

		final TextField<String> emailTextField = new TextField<String>("EMail");
		emailTextField.setRequired(true);
		emailTextField.add(new UserNotExistValidator(_userDao));

		final PasswordTextField passwordTextField = new PasswordTextField("Password");
		final PasswordTextField passwordTextField2 = new PasswordTextField("Password2");

		//		FormComponentFeedbackIndicator fehlerEmail=new FormComponentFeedbackIndicator("fehlerEmail");
		//		fehlerEmail.setIndicatorFor(emailTextField);
		//		add(fehlerEmail);

		ComponentFeedbackPanel fehlerEmail = new ComponentFeedbackPanel("EMail.Fehler", emailTextField);
		form.add(fehlerEmail);

		ComponentFeedbackPanel fehlerPassword = new ComponentFeedbackPanel("Password.Fehler", passwordTextField);
		form.add(fehlerPassword);
		ComponentFeedbackPanel fehlerPassword2 = new ComponentFeedbackPanel("Password2.Fehler", passwordTextField2);
		form.add(fehlerPassword2);

		form.add(emailTextField);
		form.add(passwordTextField);
		form.add(passwordTextField2);

		form.add(new Button("submit"));

		form.add(new EqualPasswordInputValidator(passwordTextField, passwordTextField2));

		//		IFormValidator validator=new AbstractFormValidator()
		//		{
		//			public FormComponent<?>[] getDependentFormComponents()
		//			{
		//				// TODO Auto-generated method stub
		//				return new FormComponent[]{emailTextField,passwordTextField,passwordTextField2};
		//			}
		//			
		//			public void validate(Form<?> form)
		//			{
		//				String email=emailTextField.getInput();
		//				String pass=passwordTextField.getInput();
		//				
		//				
		//				User user = _userDao.getByEMail(email);
		//				if (user==null)
		//				{
		//					user=new User();
		//					user.setEMail(email);
		//					user.setPassword(pass);
		//					_userDao.save(user);
		//					info("User wurde angelegt");
		//				}
		//				else error(emailTextField,"Exist");
		//			}
		//		};

		//		form.add(validator);

		add(form);

	}

	protected abstract void onRegisteredUser(User user);

	public static class RegisterData implements Serializable {

		String _eMail;

		String _password;

		String _password2;

		public String getEMail() {
			return _eMail;
		}

		public void setEMail(String mail) {
			_eMail = mail;
		}

		public String getPassword() {
			return _password;
		}

		public void setPassword(String password) {
			_password = password;
		}

		public String getPassword2() {
			return _password2;
		}

		public void setPassword2(String password2) {
			_password2 = password2;
		}

	}

}
