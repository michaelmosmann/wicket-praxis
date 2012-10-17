package de.wicketpraxis;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.pageserializer.kryo.DebuggingKryo;
import org.wicketstuff.pageserializer.kryo.KryoSerializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Output;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see de.wicketpraxis.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	private final static Logger LOG = LoggerFactory.getLogger(WicketApplication.class);
	
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

		getFrameworkSettings().setSerializer(new KryoSerializer(Bytes.bytes(25*1024*1024))
		{

			@Override
			protected Kryo createKryo()
			{
				return new DebuggingKryo() {
					@Override
					public void writeObjectOrNull(Output output, Object object,
							Serializer serializer) {
						super.writeObjectOrNull(output, object, serializer);
						
						if (object != null)
						{
							LOG.error("Wrote '{}' bytes for object: '{}'", output.position(), object.getClass());
						}
					}
					
					@Override
					public void writeObject(Output output, Object object) {
						super.writeObject(output, object);
						if (object != null)
						{
							LOG.error("Wrote '{}' bytes for object: '{}'", output.position(), object.getClass());
						}
					}
					@Override
					public void writeObject(Output output, Object object,
							Serializer serializer) {
						super.writeObject(output, object, serializer);
						if (object != null)
						{
							LOG.error("Wrote '{}' bytes for object: '{}'", output.position(), object.getClass());
						}
					}
					@Override
					public void writeObjectOrNull(Output output, Object object,
							Class type) {
						super.writeObjectOrNull(output, object, type);
						if (object != null)
						{
							LOG.error("Wrote '{}' bytes for object: '{}'", output.position(), object.getClass());
						}
					}
				};
				/* .blacklist(Some.class) */
			}
		});	
	}
}
