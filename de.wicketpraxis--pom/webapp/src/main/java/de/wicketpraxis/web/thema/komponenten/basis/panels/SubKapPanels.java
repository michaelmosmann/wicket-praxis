/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;

@TitleAnnotation(title = "Panel,Fragment etc.")
public class SubKapPanels extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SimplePanelPage.class);
		pages.add(SimpleFragmentPage.class);
		pages.add(SimpleBorderPage.class);
		pages.add(ComplexBorderPage.class);
		pages.add(VisibleBorderPage.class);
		pages.add(ComponentBorderPage.class);
		pages.add(SimpleWebMarkupContainerPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapBasiskomponenten.class;
	}

}
