/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class AttributeModifierPage extends WebPage {

	public AttributeModifierPage() {
		add(new WebMarkupContainer("div1").add(new AttributeModifier("style", true, Model.of("border:2px solid red;"))));
		add(new WebMarkupContainer("div2").add(new AttributeAppender("style", true, Model.of("border-left:2px solid red"),
				";")));
		add(new WebMarkupContainer("div3").add(new SimpleAttributeModifier("style", "border-right:2px solid red;")));
	}
}
