/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.pages;

import java.util.List;

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.apps.example.styles.Style;

public abstract class AbstractBasePage extends WebPage
{
	public AbstractBasePage()
	{
		List<IHeaderContributor> css = Style.getCss();
		for (IHeaderContributor h : css)
		{
			add(new HeaderContributor(h));
		}
	}
}
