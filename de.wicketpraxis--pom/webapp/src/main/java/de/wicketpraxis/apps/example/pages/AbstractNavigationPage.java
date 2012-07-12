/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.pages;

import java.util.List;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.apps.example.components.layout.Grid;
import de.wicketpraxis.apps.example.components.layout.Line;
import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.apps.example.components.navigation.NavigationPanel;

public abstract class AbstractNavigationPage extends AbstractBasePage {

	public AbstractNavigationPage() {
		Line head = new Line("head");
		Grid logo = new Grid("logo", 2);

		Grid claim = new Grid("claim", 14);
		claim.add(new Claim("claimPanel"));

		head.add(logo);
		head.add(claim);
		add(head);

		Line main = new Line("main");
		Grid nav = new Grid("navigation", 4);
		nav.add(new NavigationPanel("navigationPanel", getNavigation()));
		Grid content = new Grid("content", 12);
		main.add(nav);
		main.add(content);
		add(main);
	}

	protected abstract IModel<List<NavigationCallbackInterface>> getNavigation();
}
