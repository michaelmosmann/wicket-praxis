/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.basepage;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.LoadableDetachableModel;

import de.wicketpraxis.web.thema.howto.basepage.nav.NavCallbackInterface;
import de.wicketpraxis.web.thema.howto.basepage.nav.NavPanel;

public abstract class AbstractBasePage extends WebPage {

	public AbstractBasePage() {
		add(CSSPackageResource.getHeaderContribution(AbstractBasePage.class, "styles/base.css", "all"));

		LoadableDetachableModel<NavCallbackInterface> navModel = new LoadableDetachableModel<NavCallbackInterface>() {

			@Override
			protected NavCallbackInterface load() {
				return NavInfo.getMainNaviagtion();
			}
		};
		add(new NavPanel("nav", navModel));

		WebMarkupContainer webMarkupContainer = new WebMarkupContainer("main") {

			@Override
			public boolean isTransparentResolver() {
				return true;
			}
		};
		add(webMarkupContainer);
	}

	public abstract List<NavCallbackInterface> getNavigations();
}
