/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.basepage.nav;

import java.util.List;

import org.apache.wicket.Page;

public interface NavCallbackInterface {

	public String getName();

	public List<NavCallbackInterface> getChilds(Page page);

	public boolean isActive(Page page);

	public void onClick(Page page);
}
