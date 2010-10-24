/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.components.navigation;

import java.util.List;

public abstract class AbstractNavigationCallback implements NavigationCallbackInterface
{

	public List<NavigationCallbackInterface> getChilds()
	{
		return null;
	}
	
}
