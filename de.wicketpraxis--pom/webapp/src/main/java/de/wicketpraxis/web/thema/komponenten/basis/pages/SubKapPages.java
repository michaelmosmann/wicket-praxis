/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;
import de.wicketpraxis.web.thema.komponenten.basis.panels.SimplePanelPage;

@TitleAnnotation(title="Pages")
public class SubKapPages extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimplePage.class);
		pages.add(VerySimplePage.class);
		pages.add(RedirectExternalPage.class);
		pages.add(RedirectInternalPage.class);
		pages.add(RedirectHttpTemporaryPage.class);
		pages.add(RedirectHttpPermanentPage.class);
		pages.add(GetCurrentUrlPage.class);
		pages.add(MigrationPage.class);
		pages.add(HeaderReferencesPage.class);
	}
	
	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return SubKapBasiskomponenten.class;
	}

}
