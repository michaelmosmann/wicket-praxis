/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.req;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Request Cycle Test")
public class KapRequest extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(NotStoreablePage.class);
		pages.add(ReqZyklusPage.class);
	}

	@Override
	protected String getTitle()
	{
		return "Request Zyklus";
	}

}
