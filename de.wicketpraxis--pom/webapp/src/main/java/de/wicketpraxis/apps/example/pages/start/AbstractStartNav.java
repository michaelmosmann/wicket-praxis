/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.pages.start;

import org.apache.wicket.Page;

import de.wicketpraxis.apps.example.components.navigation.AbstractNavigationCallback;
import de.wicketpraxis.apps.example.pages.Start;

public abstract class AbstractStartNav extends AbstractNavigationCallback {

	public abstract String getID();

	public void onClick(Page page) {
		if (page instanceof Start) {
			((Start) page).clickFrom(this);
		}
	}
}
