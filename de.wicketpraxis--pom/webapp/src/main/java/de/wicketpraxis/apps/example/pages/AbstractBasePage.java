/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.pages;

import java.util.List;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.internal.HtmlHeaderContainer;

import de.wicketpraxis.apps.example.styles.Style;

public abstract class AbstractBasePage extends WebPage {
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		List<IHeaderContributor> css = Style.getCss();
		for (IHeaderContributor h : css) {
			h.renderHead(response);
		}
	}
}
