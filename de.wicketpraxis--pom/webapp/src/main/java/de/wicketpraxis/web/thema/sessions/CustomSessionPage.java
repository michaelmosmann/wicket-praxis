/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.sessions;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.pages.SecurePageInterface;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Custom Session - see /app/session/")
public class CustomSessionPage extends WebPage implements SecurePageInterface {

	public CustomSessionPage() {

	}
}
