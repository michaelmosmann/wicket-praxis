/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;
import de.wicketpraxis.web.thema.komponenten.vererbung.extension.SimpleExtensionPage;
import de.wicketpraxis.web.thema.komponenten.vererbung.extension2.AbstractExtensionPage;
import de.wicketpraxis.web.thema.komponenten.vererbung.extension3.ExtendedExtensionPage;

public class SubKapVererbung extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimpleExtensionPage.class);
		pages.add(AbstractExtensionPage.class);
		pages.add(ExtendedExtensionPage.class);
	}

	@Override
	protected String getTitle()
	{
		return "Vererbung";
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return KapKomponenten.class;
	}
}
