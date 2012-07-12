/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.session;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.CompoundAuthorizationStrategy;
import org.apache.wicket.authorization.strategies.action.ActionAuthorizationStrategy;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import de.wicketpraxis.apps.session.auth.UserLoginSecureComponentAuthStrategy;
import de.wicketpraxis.apps.session.auth.UserLoginSecureComponentDisableAuthStrategy;
import de.wicketpraxis.apps.session.auth.UserLoginSimplePageAuthStrategy;
import de.wicketpraxis.apps.session.pages.LoginPage;
import de.wicketpraxis.apps.session.pages.Start;
import de.wicketpraxis.apps.session.session.SecurePageSession;
import de.wicketpraxis.wicket.util.resource.MavenDevResourceStreamLocator;

public class SecurePageApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		if (RuntimeConfigurationType.DEVELOPMENT==getConfigurationType()) {
			getResourceSettings().setResourceStreamLocator(new MavenDevResourceStreamLocator());
		}

		getSecuritySettings().setAuthorizationStrategy(new UserLoginSimplePageAuthStrategy(LoginPage.class));
		//		getSecuritySettings().setAuthorizationStrategy(new UserLoginSecureComponentAuthStrategy(LoginPage.class));
		//		getSecuritySettings().setAuthorizationStrategy(new UserLoginSecureComponentDisableAuthStrategy());

		if (false) {
			ActionAuthorizationStrategy actionStrategy;
			CompoundAuthorizationStrategy compoundStrategy;
		}
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Start.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new SecurePageSession(request);
	}

}
