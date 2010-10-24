/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Redirect per Http (Permanent)")
public class RedirectHttpPermanentPage extends WebPage
{
	public RedirectHttpPermanentPage()
	{
		getRequestCycle().setRequestTarget(new RedirectPermanentRequestTarget("http://www.google.de"));
	}
	
}
