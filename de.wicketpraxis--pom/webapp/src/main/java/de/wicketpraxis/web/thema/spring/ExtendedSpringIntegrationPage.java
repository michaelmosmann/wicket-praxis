/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.spring;

import org.apache.wicket.injection.web.InjectorHolder;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class ExtendedSpringIntegrationPage extends WebPage
{
	public ExtendedSpringIntegrationPage()
	{
		add(new Label("message",new SimpleNonWicketClass().getEmail()));
	}
	
	public static class SimpleNonWicketClass
	{
		@SpringBean
		UserDao _userDao;
		
		public SimpleNonWicketClass()
		{
			InjectorHolder.getInjector().inject(this);
		}
		
		public String getEmail()
		{
			User user = _userDao.getByEMail("test@wicket-praxis.de");
			if (user!=null) return user.getEMail();
			return null;
		}
	}
}
