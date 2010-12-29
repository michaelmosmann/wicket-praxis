/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Wicket Message Tag - no Code")
public class WicketMessageTagPage extends WebPage {

	public WicketMessageTagPage() {

	}

	public String getHello() {
		return "I am a Wicket Message Page";
	}
}
