package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.wicketstuff.pageserializer.fast.InspectingFastWicketSerializer;
import org.wicketstuff.pageserializer.kryo2.inspecting.InspectingKryoSerializer;

import de.wicketpraxis.serializer.ReportConfigBuilder;
import de.wicketpraxis.serializer.SerializerAdapter;

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
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		getFrameworkSettings().setSerializer(new SerializerAdapter(getApplicationKey()));

	}
}
