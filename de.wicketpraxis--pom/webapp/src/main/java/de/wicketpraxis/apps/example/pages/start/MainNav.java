/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.pages.start;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.apps.example.pages.Start;

public class MainNav extends AbstractStartNav
{
	public String getName()
	{
		return "Start";
	}
	
	public boolean isActive(Page page)
	{
		return page.getClass()==Start.class;
	}
	
	public List<NavigationCallbackInterface> getChilds()
	{
		List<NavigationCallbackInterface> ret=new ArrayList<NavigationCallbackInterface>();
		ret.add(new AbstractSubNav("Unterpunkt 1")
		{
			@Override
			public String getID()
			{
				return "Sub1";
			}
		});
		ret.add(new AbstractSubNav("Unterpunkt 2")
		{
			@Override
			public String getID()
			{
				return "Sub2";
			}
		});
		return ret;
	}
	
	@Override
	public String getID()
	{
		return "Main";
	}
}