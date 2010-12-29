/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session.data;

import java.io.Serializable;

public class LoginBean implements Serializable {

	String _eMail;

	String _password;

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
}
