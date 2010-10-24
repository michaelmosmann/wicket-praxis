/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.spring;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.dao.UserDao;

public class SimpleSpringIntegrationPage extends WebPage
{
	// geht auch ohne name, wenn es nur eine von dem Typ gibt
	@SpringBean(name = UserDao.BEAN_ID)
	UserDao _userDao;

	public SimpleSpringIntegrationPage()
	{
		add(new Label("message",_userDao.get(1)==null ? "kein Nutzer" : "ein Nutzer"));
	}
}
