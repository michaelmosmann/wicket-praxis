/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.pages.RedirectPage;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Weiterleitung zu einer internen Seite")
public class RedirectInternalPage extends RedirectPage
{
	public RedirectInternalPage()
	{
		// funktioniert nicht
		super(new SimplePage("from "+RedirectInternalPage.class.getName()),10);
	}
}
