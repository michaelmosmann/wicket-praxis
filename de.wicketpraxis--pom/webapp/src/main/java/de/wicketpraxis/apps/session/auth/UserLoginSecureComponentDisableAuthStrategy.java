/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session.auth;

import org.apache.wicket.Component;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.request.component.IRequestableComponent;

import de.wicketpraxis.apps.session.pages.SecureComponentInterface;
import de.wicketpraxis.apps.session.session.SecurePageSession;

public class UserLoginSecureComponentDisableAuthStrategy implements IAuthorizationStrategy {

	public boolean isActionAuthorized(Component component, Action action) {
		if (component instanceof SecureComponentInterface) {
			// disable Link?
			//			if (action.getName().equals(Action.RENDER)) return true;

			if (!SecurePageSession.get().isUserLogin()) {
				return false;
			}
		}
		return true;
	}

	public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> componentClass) {
		return true;
	}
}
