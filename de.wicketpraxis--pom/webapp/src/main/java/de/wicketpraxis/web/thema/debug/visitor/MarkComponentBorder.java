/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug.visitor;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

public class MarkComponentBorder extends Behavior {

	@Override
	public void beforeRender(Component component) {
		super.beforeRender(component);
		component.getResponse().write("[--");
	}
	
	@Override
	public void afterRender(Component component) {
		super.afterRender(component);
		component.getResponse().write("--]");
	}
}
