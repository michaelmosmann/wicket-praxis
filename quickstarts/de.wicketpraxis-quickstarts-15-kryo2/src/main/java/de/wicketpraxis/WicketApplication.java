package de.wicketpraxis;

import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.pageserializer.kryo2.inspecting.InspectingKryoSerializer;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.AnalyzingSerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.ComponentIdAsLabel;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.ISerializedObjectTreeProcessor;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.NativeTypesAsLabel;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.TreeProcessors;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.SimilarNodeTreeTransformator;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.SortedTreeSizeReport;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.TreeTransformator;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.TypeSizeReport;
import org.wicketstuff.pageserializer.kryo2.inspecting.analyze.report.filter.TypeFilter;
import org.wicketstuff.pageserializer.kryo2.inspecting.listener.ISerializationListener;
import org.wicketstuff.pageserializer.kryo2.inspecting.listener.SerializationListeners;
import org.wicketstuff.pageserializer.kryo2.inspecting.validation.DefaultJavaSerializationValidator;

import de.wicketpraxis.usecase.dateformat.DateContainerConverter;
import de.wicketpraxis.usecase.dateformat.FullDate;
import de.wicketpraxis.usecase.dateformat.SmallDate;

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

		// output of report of type sizes, sorted tree report (by size), aggregated tree 
		ISerializedObjectTreeProcessor typeAndSortedTreeAndCollapsedSortedTreeProcessors = TreeProcessors.listOf(
			new TypeSizeReport(), new SortedTreeSizeReport(), new SimilarNodeTreeTransformator(
				new SortedTreeSizeReport()));

		// strips class object writes from tree
		TreeTransformator treeProcessors = new TreeTransformator(
			typeAndSortedTreeAndCollapsedSortedTreeProcessors,
			TreeTransformator.strip(new TypeFilter(Class.class)));

		// serialization listener notified on every written object
		ISerializationListener serializationListener = SerializationListeners.listOf(
			new DefaultJavaSerializationValidator(), new AnalyzingSerializationListener(
				new NativeTypesAsLabel(new ComponentIdAsLabel()), treeProcessors));

		// customized serializer
		InspectingKryoSerializer serializer = new InspectingKryoSerializer(Bytes.megabytes(30L),
			serializationListener);

		// set custom serializer as default
		getFrameworkSettings().setSerializer(serializer);
		
		getStoreSettings().setAsynchronous(false);
		getStoreSettings().setInmemoryCacheSize(0);
		getPageSettings().setVersionPagesByDefault(true);
	}
	
	@Override
	protected IConverterLocator newConverterLocator()
	{
		ConverterLocator ret = new ConverterLocator();
		ret.set(SmallDate.class, new DateContainerConverter<SmallDate>(SmallDate.class, "dd.MM.yyyy"));
		ret.set(FullDate.class, new DateContainerConverter<FullDate>(FullDate.class, "dd.MM.yyyy HH:mm:ss"));
		return ret;
	}
}
