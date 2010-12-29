/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.pages;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.components.register.AbstractRegisterUserPanel;
import de.wicketpraxis.web.pages.user.UserStartPage;
import de.wicketpraxis.web.session.WicketPraxisSession;

public class RegisterNewUserPage extends AbstractBasePage {

	public RegisterNewUserPage() {
		add(new AbstractRegisterUserPanel("register") {

			@Override
			protected void onRegisteredUser(User user) {
				WicketPraxisSession.get().setUser(user);
				setResponsePage(WicketPraxisApplication.get().getUserHomePage());
			}
		});
	}
}
