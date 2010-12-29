/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.models.DummyBeanPropertyModel.PropertySelector;

@TitleAnnotation(title = "Handmade Property Model", space = true)
public class HandmadePropertyModelPage extends WebPage {

	public HandmadePropertyModelPage() {
		DummyBean bean = new DummyBean();

		DummyBeanPropertyModel<String> nameModel = new DummyBeanPropertyModel<String>(bean, PropertySelector.NAME);
		DummyBeanPropertyModel<Integer> alterModel = new DummyBeanPropertyModel<Integer>(bean, PropertySelector.ALTER);

		nameModel.setObject("Klaus");
		alterModel.setObject(28);

		add(new Label("name", nameModel));
		add(new Label("alter", alterModel));

	}
}
