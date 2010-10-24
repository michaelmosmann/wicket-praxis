/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.session;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.injection.web.InjectorHolder;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class WicketPraxisSession extends WebSession
{
	@SpringBean(name=UserDao.BEAN_ID)
	UserDao _userDao;
	
	Integer _userId;
	
	public WicketPraxisSession(Request request)
	{
		super(request);
		InjectorHolder.getInjector().inject(this);
	}
	
	public synchronized void setUser(User user)
	{
		_userId = user.getId();
		dirty();
	}
	
	public synchronized void clearUser()
	{
		_userId = null;
		dirty();
	}
	
	public synchronized User getUser()
	{
		if (_userId!=null) return _userDao.get(_userId);
		return null;
	}
	
	public synchronized boolean isUserLogin()
	{
		return _userId!=null ? true : false;
	}
	
	public static WicketPraxisSession get()
	{
		return (WicketPraxisSession) Session.get();
	}
}
