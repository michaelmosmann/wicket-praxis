/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class SimpleBehaviorPage extends WebPage {

	public SimpleBehaviorPage() {
		add(new Label("message", "Text").add(new OnMouseUpInnerHtmlBehavior("neuer Text")));
	}

	static class OnMouseUpInnerHtmlBehavior extends Behavior {

		String _content;

		public OnMouseUpInnerHtmlBehavior(String content) {
			_content = content;
		}

		@Override
		public void onComponentTag(Component component, ComponentTag tag) {
			tag.put("onmouseup", "this.innerHTML = '" + _content + "'");
		}
	}
}
