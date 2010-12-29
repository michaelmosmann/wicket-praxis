/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.howto.basepage.StartPage;
import de.wicketpraxis.web.thema.howto.css.BasePageWithCSS;
import de.wicketpraxis.web.thema.howto.links.LinksPage;
import de.wicketpraxis.web.thema.howto.modify2.OwnComponentsPage;
import de.wicketpraxis.web.thema.howto.mount.MountedPage;
import de.wicketpraxis.web.thema.howto.optimize.OptimizePage;
import de.wicketpraxis.web.thema.howto.replace.ComponentReplacePage;
import de.wicketpraxis.web.thema.howto.replace.WizardPage;
import de.wicketpraxis.web.thema.howto.res.forms.ResourceFromFormPage;
import de.wicketpraxis.web.thema.howto.res.images.DynamicImagePage;
import de.wicketpraxis.web.thema.howto.res.images.ImageFromDatabasePage;
import de.wicketpraxis.web.thema.howto.res.shared.RssFeedPage;
import de.wicketpraxis.web.thema.howto.res.shared.SharedResourcesPage;
import de.wicketpraxis.web.thema.howto.seolinks.SeoLinksPage;
import de.wicketpraxis.web.thema.howto.servletfilter.FilterPage;
import de.wicketpraxis.web.thema.howto.trackingcode.GoogleAnalyticsCodePage;

@TitleAnnotation(title = "HowTo")
public class KapHowto extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		// standard
		pages.add(StartPage.class);
		pages.add(BasePageWithCSS.class);
		pages.add(OwnComponentsPage.class);

		// component replace
		pages.add(ComponentReplacePage.class);
		pages.add(WizardPage.class);

		// seo
		pages.add(MountedPage.class);
		pages.add(SeoLinksPage.class);
		pages.add(FilterPage.class);
		pages.add(GoogleAnalyticsCodePage.class);

		// resourcen und links
		pages.add(DynamicImagePage.class);
		pages.add(ImageFromDatabasePage.class);
		pages.add(ResourceFromFormPage.class);
		pages.add(SharedResourcesPage.class);
		pages.add(RssFeedPage.class);
		pages.add(LinksPage.class);

		// optimize
		pages.add(OptimizePage.class);
	}
}
