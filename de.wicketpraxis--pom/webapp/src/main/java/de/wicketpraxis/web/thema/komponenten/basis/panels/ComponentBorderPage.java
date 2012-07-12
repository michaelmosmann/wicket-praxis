/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.BorderBehavior;

public class ComponentBorderPage extends WebPage {

	public ComponentBorderPage() {
		add(new Label("l1", "in red border").add(new RedBorder()));
		add(new Label("l2", "in blue border").add(new BlueBorder()));
	}

	static class RedBorder extends Behavior {

		@Override
		public void beforeRender(Component component) {
			component.getResponse().write("<div style=\"border:1px solid red;\">");
		}

		@Override
		public void afterRender(Component component) {
			component.getResponse().write("</div>");
		}
	}

	static class BlueBorder extends BorderBehavior {

	}
}
