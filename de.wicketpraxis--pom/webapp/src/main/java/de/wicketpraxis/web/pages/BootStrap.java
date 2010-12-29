/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.thema.OverViewPage;

public class BootStrap extends WebPage {

	private static final Logger _logger = LoggerFactory.getLogger(BootStrap.class);

	@SpringBean
	UserDao _userDao;

	public BootStrap() {
		String[][] fixture = { {"test@wicket-praxis.de", "1234", "klaus"}, {"klaus@im-urlaub.de", "1234", "klaus"},
				{"hans@mondlandung.de", "1234", "hans"}, {"alfred@in-der-kiste.com", "1234", "alfred"},
				{"bert@fred.de", "1234", "bert"}, {"susi@sommer.net", "1234", "susi"}, {"a.e@neumann.de", "1234", "alfred"},
				{"m@jack-sohn.de", "1234", "michael"},};

		_logger.info("Bootstrapping");
		for (String[] f : fixture) {
			String email = f[0];
			String pass = f[1];
			String name = f[2];
			User user = _userDao.getByEMail(email);
			if (user == null) {
				_logger.info("Bootstrap: {}", email);
				user = new User();
				user.setEMail(email);
				user.setPassword(pass);
				user.setName(name);
				_userDao.save(user);
			}
		}
		WicketPraxisApplication.get().setHomePage(OverViewPage.class);

		setResponsePage(OverViewPage.class);

	}
}
