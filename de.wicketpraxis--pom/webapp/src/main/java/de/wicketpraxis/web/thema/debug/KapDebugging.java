/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.debug.markup.DebugMarkupPage;
import de.wicketpraxis.web.thema.debug.pageinfo.PageInfoPage;
import de.wicketpraxis.web.thema.debug.unittests.UnitTestPage;
import de.wicketpraxis.web.thema.debug.visitor.DebugByVisitorPage;
import de.wicketpraxis.web.thema.howto.basepage.StartPage;
import de.wicketpraxis.web.thema.howto.css.BasePageWithCSS;
import de.wicketpraxis.web.thema.howto.links.LinksPage;
import de.wicketpraxis.web.thema.howto.modify.OwnComponentsPage;
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

@TitleAnnotation(title = "Debugging")
public class KapDebugging extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(UnitTestPage.class);
		pages.add(PageInfoPage.class);
		pages.add(DebugByVisitorPage.class);
		pages.add(DebugMarkupPage.class);
	}
}
