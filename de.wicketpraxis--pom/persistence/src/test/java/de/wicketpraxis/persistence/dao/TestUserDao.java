/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.dao;

import junit.framework.Assert;
import de.wicketpraxis.persistence.AbstractTest;
import de.wicketpraxis.persistence.beans.User;

public class TestUserDao extends AbstractTest
{
	public void testKeinNutzer()
	{
		UserDao userDao = getBean(UserDao.BEAN_ID,UserDao.class);
		
		User nutzer = userDao.get(1);
		
		Assert.assertNull("Kein Nutzer",nutzer);
	}
	
	public void testEinNutzer()
	{
		UserDao userDao = getBean(UserDao.BEAN_ID,UserDao.class);
		
		User nutzer=new User();
		String email = "klaus@test.de";
		nutzer.setEMail(email);
		nutzer.setName("Klaus");
		String password = "hasteMal";
		nutzer.setPassword(password);
		userDao.save(nutzer);

		nutzer=userDao.get(nutzer.getId());
		
		Assert.assertNotNull("User",nutzer);
		Assert.assertEquals("Email",email,nutzer.getEMail());
		
		nutzer=userDao.getByEMail(email);
		Assert.assertNotNull("User",nutzer);
		Assert.assertEquals("Email",email,nutzer.getEMail());
		Assert.assertEquals("Check Password",true,nutzer.isPasswordValid(password));
	}
	
}
