/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.komposition;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;

public class SubKapKomposition extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {

	}

	@Override
	protected String getTitle() {
		return "Komposition (in progress)";
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return KapKomponenten.class;
	}

}
