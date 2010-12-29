/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.navigation;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public interface NavigationCallbackInterface extends Serializable {

	public String getName();

	public List<NavigationCallbackInterface> getChilds();

	public boolean isActive(Page page);

	public void onClick(Page page);
}
