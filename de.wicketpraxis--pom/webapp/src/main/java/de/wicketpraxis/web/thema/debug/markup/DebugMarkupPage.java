/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.debug.markup;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;

import de.wicketpraxis.web.WicketPraxisApplication;
import de.wicketpraxis.web.thema.debug.unittests.CustomPanel;

public class DebugMarkupPage extends WebPage
{
	public DebugMarkupPage()
	{
		WicketPraxisApplication.get().getDebugSettings().setOutputMarkupContainerClassName(true);
		
		add(new EmptyPanel("empty"));
		
		add(new CustomPanel("custom"));
	}
}
