package de.wicketpraxis;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.pageserializer.kryo2.DebuggingKryo;
import org.wicketstuff.pageserializer.kryo2.KryoSerializer;
import org.wicketstuff.pageserializer.kryo2.inspecting.ISerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.InspectingKryoSerializer;
import org.wicketstuff.pageserializer.kryo2.inspecting.LoggingSerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.SerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.AnalyzingSerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.IObjectLabelizer;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.ISerializedObjectTree;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.ISerializedObjectTreeProcessor;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.TreeProcessors;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.ITreeFilter;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.Level;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.SortedTreeSizeReport;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.TreeSizeReport;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.TreeTransformator;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.TypeSizeReport;
import org.wicketstuff.pageserializer.kryo2.inspecting.validation.DefaultJavaSerializationValidator;

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

		ISerializationListener listener=createListener();
		getFrameworkSettings().setSerializer(new InspectingKryoSerializer(Bytes.bytes(25*1024*1024), listener));
		
		if (false) getFrameworkSettings().setSerializer(new KryoSerializer(Bytes.bytes(25*1024*1024))
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

	private ISerializationListener createListener()
	{
		IObjectLabelizer labelizer = new IObjectLabelizer()
		{
			@Override
			public String labelFor(Object object)
			{
				return null;
			}
		};
		
		ISerializedObjectTreeProcessor treeProcessor = TreeProcessors.listOf(new TypeSizeReport(),
			new TreeSizeReport(), new SortedTreeSizeReport());
		ITreeFilter filter=new ITreeFilter()
		{
			@Override
			public boolean accept(ISerializedObjectTree source, Level current)
			{
				return source.type()!=Class.class;
			}
		};
		ISerializedObjectTreeProcessor cleanedTreeProcessor = new TreeTransformator(treeProcessor, TreeTransformator.strip(filter));
		ISerializationListener listener = SerializationListener.listOf(new DefaultJavaSerializationValidator(),
			new LoggingSerializationListener(), new AnalyzingSerializationListener(labelizer,
				treeProcessor), new AnalyzingSerializationListener(labelizer,
					cleanedTreeProcessor));
		return listener;
	}
}
