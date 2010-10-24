/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;
import java.text.MessageFormat;

public class LoginBean implements Serializable
{
	String _eMail;
	String _password;
	String _password2;
	
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

	public String getPassword2()
	{
		return _password2;
	}

	public void setPassword2(String password2)
	{
		_password2 = password2;
	}

	public String toString()
	{
		return MessageFormat.format("EMail: {0}, Password: {1}, Password2: {2}", _eMail,_password,_password2);
	}
	
}
