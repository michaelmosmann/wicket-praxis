/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.resources;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;
import de.wicketpraxis.web.thema.komponenten.basis.panels.SimplePanelPage;

@TitleAnnotation(title="Resources")
public class SubKapResources extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(ResourceRefPage.class);
	}
	
	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return SubKapBasiskomponenten.class;
	}

}
