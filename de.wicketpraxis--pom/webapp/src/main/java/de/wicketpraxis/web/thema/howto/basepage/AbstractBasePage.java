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
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.PackageResourceGuard;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import de.wicketpraxis.web.thema.howto.basepage.nav.NavCallbackInterface;
import de.wicketpraxis.web.thema.howto.basepage.nav.NavPanel;

public abstract class AbstractBasePage extends WebPage {

	public AbstractBasePage() {
		LoadableDetachableModel<NavCallbackInterface> navModel = new LoadableDetachableModel<NavCallbackInterface>() {

			@Override
			protected NavCallbackInterface load() {
				return NavInfo.getMainNaviagtion();
			}
		};
		add(new NavPanel("nav", navModel));

		WebMarkupContainer webMarkupContainer = new WebMarkupContainer("main");
		add(webMarkupContainer);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderCSSReference(new PackageResourceReference(AbstractBasePage.class, "styles/base.css"), "all");
	}

	public abstract List<NavCallbackInterface> getNavigations();
}
