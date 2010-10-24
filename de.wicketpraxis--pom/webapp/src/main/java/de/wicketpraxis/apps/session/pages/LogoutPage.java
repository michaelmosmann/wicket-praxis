/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.session.pages;

import de.wicketpraxis.apps.session.SecurePageApplication;
import de.wicketpraxis.apps.session.session.SecurePageSession;

public class LogoutPage extends AbstractBasePage
{
	public LogoutPage()
	{
		SecurePageSession.get().clearUser();
		setResponsePage(SecurePageApplication.get().getHomePage());
	}
}
