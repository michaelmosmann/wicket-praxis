package de.wicketpraxis;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.serialize.ISerializer;
import org.apache.wicket.serialize.java.JavaSerializer;

import de.wicketpraxis.serializer.DevelopmentJavaSerializer;

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
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		getFrameworkSettings().setSerializer(new DevelopmentJavaSerializer(getApplicationKey()));
		
		getStoreSettings().setAsynchronous(false);
		getStoreSettings().setInmemoryCacheSize(0);
		getPageSettings().setVersionPagesByDefault(true);	}
}
