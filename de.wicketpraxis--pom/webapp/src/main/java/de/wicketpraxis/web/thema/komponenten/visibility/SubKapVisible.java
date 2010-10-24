/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.visibility;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;
import de.wicketpraxis.web.thema.komponenten.basis.panels.VisibleBorderPage;

@TitleAnnotation(title="Sichtbarkeit")
public class SubKapVisible extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimpleVisiblePage.class);
		pages.add(EnclosurePage.class);
		pages.add(VisibleBorderPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return KapKomponenten.class;
	}
}
