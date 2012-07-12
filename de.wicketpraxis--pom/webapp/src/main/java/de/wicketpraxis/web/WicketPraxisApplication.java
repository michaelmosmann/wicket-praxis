/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.SharedResources;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;

import de.wicketpraxis.web.pages.BootStrap;
import de.wicketpraxis.web.pages.SecurePageInterface;
import de.wicketpraxis.web.pages.user.AbstractUserBasePage;
import de.wicketpraxis.web.pages.user.UserStartPage;
import de.wicketpraxis.web.session.WicketPraxisSession;
import de.wicketpraxis.web.thema.howto.links.LinksPage;
import de.wicketpraxis.web.thema.howto.mount.PageMount;
import de.wicketpraxis.web.thema.howto.res.shared.RssFeedPage;
import de.wicketpraxis.web.thema.howto.res.shared.SharedResourcesPage;
import de.wicketpraxis.wicket.util.resource.MavenDevResourceStreamLocator;

public class WicketPraxisApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		if (RuntimeConfigurationType.DEVELOPMENT==getConfigurationType()) {
			getResourceSettings().setResourceStreamLocator(new MavenDevResourceStreamLocator());
		}

		IAuthorizationStrategy strategy = new SimplePageAuthorizationStrategy(SecurePageInterface.class, getHomePage()) {

			@Override
			protected boolean isAuthorized() {
				return WicketPraxisSession.get().isUserLogin();
			}
		};

		getSecuritySettings().setAuthorizationStrategy(strategy);

		PageMount.init(this);
		SharedResourcesPage.init(this);
		RssFeedPage.init(this);
		LinksPage.init(this);

		//		getResourceSettings().setAddLastModifiedTimeToResourceReferenceUrl(true);
		//		getMarkupSettings().setAutomaticLinking(true);
		
		// UploadWebRequest in 1.4 
		getApplicationSettings().setUploadProgressUpdatesEnabled(true);
	}

	Class<? extends Page> _homePage = BootStrap.class;

	@Override
	public Class<? extends Page> getHomePage() {
		return _homePage;
	}

	public void setHomePage(Class<? extends Page> homePage) {
		_homePage = homePage;
	}

	public Class<? extends Page> getUserHomePage() {
		return UserStartPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new WicketPraxisSession(request);
	}

	//	@Override
	//	protected IConverterLocator newConverterLocator()
	//	{
	//		return new ConverterLocatorPage.CustomConverterLocator(super.newConverterLocator());
	//	}

	public static WicketPraxisApplication get() {
		return (WicketPraxisApplication) Application.get();
	}
}
