/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;

@TitleAnnotation(title = "Links und Nav.")
public class SubKapLinks extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SimpleLinkPage.class);
		pages.add(AjaxFallbackLinkPage.class);
		pages.add(AjaxLinkPage.class);
		pages.add(LinkTrickPage.class);
		pages.add(ExternalLinkPage.class);
		pages.add(PopupLinkPage.class);

		//		pages.add(AllLinkTypesPage.class);
		pages.add(ResourceLinksPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapBasiskomponenten.class;
	}

}
