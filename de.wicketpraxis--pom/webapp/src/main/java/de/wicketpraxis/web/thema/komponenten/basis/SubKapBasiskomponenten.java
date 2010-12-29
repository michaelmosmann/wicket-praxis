/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;
import de.wicketpraxis.web.thema.komponenten.basis.content.SubKapContent;
import de.wicketpraxis.web.thema.komponenten.basis.links.SubKapLinks;
import de.wicketpraxis.web.thema.komponenten.basis.pages.RedirectExternalPage;
import de.wicketpraxis.web.thema.komponenten.basis.pages.RedirectHttpPermanentPage;
import de.wicketpraxis.web.thema.komponenten.basis.pages.RedirectInternalPage;
import de.wicketpraxis.web.thema.komponenten.basis.pages.RedirectHttpTemporaryPage;
import de.wicketpraxis.web.thema.komponenten.basis.pages.SimplePage;
import de.wicketpraxis.web.thema.komponenten.basis.pages.SubKapPages;
import de.wicketpraxis.web.thema.komponenten.basis.panels.SimplePanelPage;
import de.wicketpraxis.web.thema.komponenten.basis.panels.SubKapPanels;
import de.wicketpraxis.web.thema.komponenten.basis.repeater.SubKapRepeater;
import de.wicketpraxis.web.thema.komponenten.basis.resources.SubKapResources;

@TitleAnnotation(title = "Basiskomponenten")
public class SubKapBasiskomponenten extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SubKapResources.class);
		pages.add(SubKapPages.class);
		pages.add(SubKapPanels.class);
		pages.add(SubKapContent.class);
		pages.add(SubKapLinks.class);
		pages.add(SubKapRepeater.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return KapKomponenten.class;
	}

}
