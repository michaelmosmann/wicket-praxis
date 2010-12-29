/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.components.login;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.components.AbstractLoggedPanel;
import de.wicketpraxis.web.session.WicketPraxisSession;

public class UserHasLoginPanel extends AbstractLoggedPanel {

	@SpringBean(name = UserDao.BEAN_ID)
	UserDao _userDao;

	public UserHasLoginPanel(String id) {
		super(id);

		LoadableDetachableModel<String> userEMailModel = new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				User user = WicketPraxisSession.get().getUser();
				if (user != null)
					return user.getEMail();
				return null;
			}
		};

		add(new Label("userEMail", userEMailModel));

		add(new Link("logout") {

			public void onClick() {
				WicketPraxisSession.get().clearUser();
				setResponsePage(WicketPraxisApplication.get().getHomePage());
			};
		});
	}
}
