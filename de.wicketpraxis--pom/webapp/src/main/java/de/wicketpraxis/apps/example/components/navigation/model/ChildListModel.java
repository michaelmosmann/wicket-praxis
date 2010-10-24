/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.components.navigation.model;

import java.util.List;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.web.model.CascadingLoadableDetachableModel;

public class ChildListModel extends CascadingLoadableDetachableModel<List<NavigationCallbackInterface>, NavigationCallbackInterface>
{
	public ChildListModel(IModel<? extends NavigationCallbackInterface> parent)
	{
		super(parent);
	}

	@Override
	protected List<NavigationCallbackInterface> load(NavigationCallbackInterface p)
	{
		if (p!=null) return p.getChilds();
		return null;
	}
}
