/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class AttributeAppenderPage extends WebPage {

	public AttributeAppenderPage() {
		WebMarkupContainer div = new WebMarkupContainer("div");
		div.add(new AttributeAppender("style", true, Model.of("border-left:2px solid red"), ";"));
		div.add(new AttributeAppender("style", true, Model.of("border-right:2px solid green"), ";"));
		div.add(new AttributeAppender("style", true, Model.of("border-top:2px solid yellow"), ";"));
		div.add(new AttributeAppender("style", true, Model.of("border-bottom:2px solid blue"), ";"));
		add(div);
	}
}
