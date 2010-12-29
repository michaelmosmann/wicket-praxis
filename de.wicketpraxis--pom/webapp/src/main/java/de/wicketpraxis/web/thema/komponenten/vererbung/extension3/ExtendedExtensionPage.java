/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension3;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Extended Extension")
public class ExtendedExtensionPage extends WebPage {

	public ExtendedExtensionPage() {
		add(new HasBoxPanel("hasBox"));

		add(new AbstractBasePanel("inline") {

			@Override
			protected BasePanelLabel getMessage() {
				return new BasePanelLabel("Ich hab keine Box");
			}

			@Override
			protected Panel getChild(String id) {
				return new EmptyPanel(id);
			}
		});
	}
}
