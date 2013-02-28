package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.wicketpraxis.seoajax.SeoPage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see de.wicketpraxis.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return SeoPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		mountPage("seoPage", SeoPage.class);
		
		// add your configuration here
	}
}
