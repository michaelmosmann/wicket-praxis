/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.trackingcode;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;

public class GoogleAnalyticsCodePage extends WebPage
{
	public GoogleAnalyticsCodePage()
	{
		add(new ExternalLink("hanser","http://www.hanser.de"));
		add(new ExternalLink("wicketpraxis","http://www.wicket-praxis.de/blog"));
		add(new GoogleAnalyticsPanel("google"));
	}
	
	static class GoogleAnalyticsPanel extends AbstractGoogleAnalyticsPanel
	{

		public GoogleAnalyticsPanel(String id)
		{
			super(id);
		}

		@Override
		public String getAnalyticsCode()
		{
			return "UA-1234567";
		}

		@Override
		public String getVirtualPath()
		{
			return getPage().getClass().getName().replace('.', '/');
		}
		
	}
}
