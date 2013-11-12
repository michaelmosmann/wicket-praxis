package de.wicketpraxis.serializer;

import java.io.File;
import java.util.UUID;

import org.apache.wicket.Component;
import org.wicketstuff.pageserializer.common.analyze.AnalyzingSerializationListener;
import org.wicketstuff.pageserializer.common.analyze.IObjectLabelizer;
import org.wicketstuff.pageserializer.common.analyze.ISerializedObjectTree;
import org.wicketstuff.pageserializer.common.analyze.ISerializedObjectTreeProcessor;
import org.wicketstuff.pageserializer.common.analyze.TreeProcessors;
import org.wicketstuff.pageserializer.common.analyze.report.Level;
import org.wicketstuff.pageserializer.common.analyze.report.RenderTreeProcessor;
import org.wicketstuff.pageserializer.common.analyze.report.SimilarNodeTreeTransformator;
import org.wicketstuff.pageserializer.common.analyze.report.SortedTreeSizeReport;
import org.wicketstuff.pageserializer.common.analyze.report.TreeTransformator;
import org.wicketstuff.pageserializer.common.analyze.report.TypeSizeReport;
import org.wicketstuff.pageserializer.common.analyze.report.d3js.D3DataFileRenderer;
import org.wicketstuff.pageserializer.common.analyze.report.filter.ITreeFilter;
import org.wicketstuff.pageserializer.common.analyze.report.io.DirectoryBasedReportOutput;
import org.wicketstuff.pageserializer.common.analyze.report.io.Keys;
import org.wicketstuff.pageserializer.common.listener.ISerializationListener;
import org.wicketstuff.pageserializer.common.listener.SerializationListeners;
import org.wicketstuff.pageserializer.kryo2.inspecting.validation.DefaultJavaSerializationValidator;

public class ReportConfigBuilder {

	public static ISerializationListener build(String directory) {
		IObjectLabelizer labelizer = new IObjectLabelizer() {

			@Override
			public String labelFor(Object object) {
				if (object instanceof Component) {
					return ((Component) object).getId();
				}
				return null;
			}
		};

		DirectoryBasedReportOutput reportOutput = new DirectoryBasedReportOutput(tempDirectory(directory));

		ISerializedObjectTreeProcessor treeProcessor = TreeProcessors.listOf(
				new TypeSizeReport(reportOutput.with(Keys.withNameAndFileExtension("TypeSizeReport", "txt"))),
				new SortedTreeSizeReport(reportOutput.with(Keys.withNameAndFileExtension("SortedTreeSizeReport", "txt"))),
				new RenderTreeProcessor(reportOutput.with(Keys.withNameAndFileExtension("d3js-chart", "html")),
						new D3DataFileRenderer()),
				new SimilarNodeTreeTransformator(new SortedTreeSizeReport(reportOutput.with(Keys.withNameAndFileExtension(
						"StrippedSortedTreeSizeReport", "txt")))));
		
		ITreeFilter filter = new ITreeFilter() {

			@Override
			public boolean accept(ISerializedObjectTree source, Level current) {
				return source.type() != Class.class;
			}
		};
		ISerializedObjectTreeProcessor cleanedTreeProcessor = new TreeTransformator(treeProcessor,
				TreeTransformator.strip(filter));
		
		ISerializationListener listener = SerializationListeners.listOf(new DefaultJavaSerializationValidator(),
				new AnalyzingSerializationListener(labelizer, cleanedTreeProcessor));

		return listener;
	}

	private static File tempDirectory(String prefix) {
		File baseDir = new File(System.getProperty("java.io.tmpdir"));
		String baseName = prefix + "-" + UUID.randomUUID().toString();

		File tempDir = new File(baseDir, baseName);
		if (tempDir.mkdir()) {
			return tempDir;
		}

		throw new RuntimeException("Could not create tempdir " + baseName + " in " + baseDir);
	}

}
