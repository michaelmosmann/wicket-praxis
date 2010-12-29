/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session.auth;

import org.apache.wicket.Page;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;

import de.wicketpraxis.apps.session.pages.SecurePageInterface;
import de.wicketpraxis.apps.session.session.SecurePageSession;

public class UserLoginSimplePageAuthStrategy extends SimplePageAuthorizationStrategy {

	public UserLoginSimplePageAuthStrategy(Class<? extends Page> signInPageClass) {
		super(SecurePageInterface.class, signInPageClass);
	}

	@Override
	protected boolean isAuthorized() {
		return SecurePageSession.get().isUserLogin();
	}
}
