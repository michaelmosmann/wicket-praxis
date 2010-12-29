/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session.auth;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;

import de.wicketpraxis.apps.session.pages.SecureComponentInterface;
import de.wicketpraxis.apps.session.session.SecurePageSession;

public class UserLoginSecureComponentAuthStrategy implements IAuthorizationStrategy {

	Class<? extends Page> _signInPageClass;

	public UserLoginSecureComponentAuthStrategy(Class<? extends Page> signInPageClass) {
		_signInPageClass = signInPageClass;

		// Handle unauthorized access to pages
		// das ganze in Application.init setzen und nicht so!!
		Application.get().getSecuritySettings().setUnauthorizedComponentInstantiationListener(
				new IUnauthorizedComponentInstantiationListener() {

					public void onUnauthorizedInstantiation(final Component component) {
						throw new RestartResponseAtInterceptPageException(_signInPageClass);
					}
				});
	}

	public boolean isActionAuthorized(Component component, Action action) {
		return true;
	}

	public <T extends Component> boolean isInstantiationAuthorized(Class<T> componentClass) {
		if (SecureComponentInterface.class.isAssignableFrom(componentClass)) {
			return SecurePageSession.get().isUserLogin();
		}
		return true;
	}

}
