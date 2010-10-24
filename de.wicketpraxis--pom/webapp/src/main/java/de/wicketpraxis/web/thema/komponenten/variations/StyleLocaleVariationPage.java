/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.variations;

import java.util.Locale;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class StyleLocaleVariationPage extends WebPage
{
	public StyleLocaleVariationPage(PageParameters pageParameters)
	{
		/*
		 Suchpfad: 
		 Klassenname_variation_style_language_COUNTRY.html
		 Klassenname_variation_style_language.html
		 Klassenname_variation_style.html
		 Klassenname_language_COUNTRY.html
		 Klassenname_language.html
		 Klassenname.html

		 Properties
		 Klassenname_variation_style_language_COUNTRY.properties
		 Klassenname_variation_style_language_COUNTRY.xml
		 ...
		 Basisklasse_..
		 ...
		 
		 Packet der Klasse
		 package_..
		 und dann den Baum rauf
		 
		 WicketPraxisApplication
		 ...
		 Application
		 */
		
		String changeStyle = pageParameters.getString("style");
		if ((changeStyle!=null) && (changeStyle.length()>0))
		{
			getSession().setStyle(changeStyle);
		}
		else
		{
			getSession().setStyle(null);
		}
		
		add(new SimplePanel("pure"));
		add(new SimplePanel("withVariation","v1"));
		add(new SimplePanel("withCustomLocale","v2").setLocale(new Locale("de","CH")));
		
		add(new BookmarkablePageLink<StyleLocaleVariationPage>("rot",StyleLocaleVariationPage.class,new PageParameters("style=rot")));
		add(new BookmarkablePageLink<StyleLocaleVariationPage>("normal",StyleLocaleVariationPage.class));
	}
}
