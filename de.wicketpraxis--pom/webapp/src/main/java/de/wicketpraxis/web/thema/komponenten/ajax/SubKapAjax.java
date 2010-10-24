/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

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

@TitleAnnotation(title="Ajax")
public class SubKapAjax extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimpleAjaxPage.class);
		pages.add(SimpleAjaxEventPage.class);
		pages.add(AjaxEventPage.class);
		pages.add(AjaxEvent2Page.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return KapKomponenten.class;
	}

}
