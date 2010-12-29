/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

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

@TitleAnnotation(title = "Behaviors")
public class SubKapBehaviors extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SimpleBehaviorPage.class);
		pages.add(AttributeModifierPage.class);
		pages.add(AttributeAppenderPage.class);
		pages.add(AjaxUpdatingPage.class);

		pages.add(AutoCompletePage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return KapKomponenten.class;
	}

}
