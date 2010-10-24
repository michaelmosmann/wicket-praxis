/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.basepage;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.howto.basepage.nav.AbstractNavCallback;
import de.wicketpraxis.web.thema.howto.basepage.nav.NavCallbackInterface;
import de.wicketpraxis.web.thema.howto.basepage.nav.PageNavCallback;

public class NavInfo
{
	public static List<NavCallbackInterface> getPages()
	{
		List<NavCallbackInterface> ret=new ArrayList<NavCallbackInterface>();
		ret.add(new PageNavCallback(StartPage.class,"Start"));
		ret.add(new PageNavCallback(SecondPage.class,"Zweite Seite"));
		return ret;
	}

	public static NavCallbackInterface getMainNaviagtion()
	{
		return new AbstractNavCallback(null)
		{
			public List<NavCallbackInterface> getChilds(Page page)
			{
				return getPages();
			}

			public void onClick(Page page)
			{
			}
		};
	};
}
