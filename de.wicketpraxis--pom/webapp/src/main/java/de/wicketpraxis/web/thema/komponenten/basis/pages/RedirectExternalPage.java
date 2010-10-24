/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.pages.RedirectPage;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Weiterleitung zu Google")
public class RedirectExternalPage extends RedirectPage
{
	public RedirectExternalPage()
	{
		super("http://www.google.com",10);
		
		add(new Label("url","http://www.google.com"));
	}
}
