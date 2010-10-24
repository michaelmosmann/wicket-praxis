/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.basepage.nav;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.howto.basepage.AbstractBasePage;

public class PageNavCallback extends AbstractNavCallback
{
	Class<? extends Page> _pageClass;

	public PageNavCallback(Class<? extends Page> pageClass,String name)
	{
		super(name);
		_pageClass=pageClass;
	}
	
	public List<NavCallbackInterface> getChilds(Page page)
	{
		if (page.getClass()==_pageClass)
		{
			if (page instanceof AbstractBasePage)
			{
				return ((AbstractBasePage) page).getNavigations();
			}
		}
		return null;
	}

	public boolean isActive(Page page)
	{
		return page.getClass()==_pageClass;
	}

	public void onClick(Page page)
	{
		page.setResponsePage(_pageClass);
	}
	
}
