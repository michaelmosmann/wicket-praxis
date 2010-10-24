/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.basepage;

import java.util.List;

import de.wicketpraxis.web.thema.howto.basepage.nav.NavCallbackInterface;

public class SecondPage extends AbstractBasePage
{
	public SecondPage()
	{
	}
	
	@Override
	public List<NavCallbackInterface> getNavigations()
	{
		return null;
	}
}
