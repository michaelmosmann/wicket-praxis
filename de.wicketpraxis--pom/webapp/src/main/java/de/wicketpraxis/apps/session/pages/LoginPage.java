/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.apps.session.SecurePageApplication;
import de.wicketpraxis.apps.session.data.LoginBean;
import de.wicketpraxis.apps.session.session.SecurePageSession;
import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class LoginPage extends AbstractBasePage {

	@SpringBean(name = UserDao.BEAN_ID)
	UserDao _userDao;

	public LoginPage() {
		add(new FeedbackPanel("feedback"));

		Form<LoginBean> form = new Form<LoginBean>("form", new CompoundPropertyModel<LoginBean>(new LoginBean())) {

			@Override
			protected void onSubmit() {
				LoginBean loginBean = getModel().getObject();
				User user = _userDao.getByEMail(loginBean.getEMail());
				if (user != null) {
					if (user.isPasswordValid(loginBean.getPassword())) {
						SecurePageSession.get().setUser(user);
						continueToOriginalDestination();
						setResponsePage(SecurePageApplication.get().getHomePage());
					} else {
						error("EMail oder Passwort falsch (Passwort natürlich)");
					}
				} else {
					error("EMail oder Passwort falsch (EMail natürlich)");
				}
			}
		};
		form.add(new TextField<String>("EMail").setRequired(true));
		form.add(new PasswordTextField("Password"));
		add(form);
	}
}
