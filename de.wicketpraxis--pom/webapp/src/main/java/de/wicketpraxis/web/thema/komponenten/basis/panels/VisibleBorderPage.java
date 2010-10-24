/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.variations.StyleLocaleVariationPage;

public class VisibleBorderPage extends WebPage
{
	public VisibleBorderPage(PageParameters pageParameters)
	{
		AbstractVisibleBorder<String> border=new AbstractVisibleBorder<String>("border",Model.of(pageParameters.getString("border")))
		{
			@Override
			protected boolean isVisibleWith(String object)
			{
				if ((object==null) || (object.equals("show")))
				{
					return true;
				}
				return false;
			}
		};
		border.add(new Label("message","in a border"));
		add(border);
		
		AbstractVisibleBorder<String> invers = border.getInvers("invers");
		invers.add(new Label("message","second in a border"));
		add(invers);
		
		add(new BookmarkablePageLink<VisibleBorderPage>("show",VisibleBorderPage.class));
		add(new BookmarkablePageLink<VisibleBorderPage>("hide",VisibleBorderPage.class,new PageParameters("border=hide")));

	}
}
