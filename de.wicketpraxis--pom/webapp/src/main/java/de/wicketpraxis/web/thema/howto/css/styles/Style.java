/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.css.styles;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.PackageResourceReference;

import de.wicketpraxis.web.thema.howto.css.styles.header.IEConditionalHeader;

public class Style {

	public static List<IHeaderContributor> getCss() {
		List<IHeaderContributor> ret = new ArrayList<IHeaderContributor>();
		ret.add(new CSS(Style.class, "grid960/reset.css", "all"));
		ret.add(new CSS(Style.class, "grid960/text.css", "all"));
		ret.add(new CSS(Style.class, "grid960/960.css", "all"));
		ret.add(new CSS(Style.class, "base.css", "all"));

		ret.add(IEConditionalHeader.START);
		ret.add(new CSS(Style.class, "ieOnly.css", "all"));
		ret.add(IEConditionalHeader.END);
		return ret;
	}
	
	static class CSS implements IHeaderContributor {

		private Class<?> _clazz;
		private String _resource;
		private String _media;
		
		public CSS(Class<?> clazz, String resource, String media) {
			super();
			_clazz = clazz;
			_resource = resource;
			_media = media;
		}

		@Override
		public void renderHead(IHeaderResponse response) {
			response.renderCSSReference(new PackageResourceReference(_clazz, _resource),_media);
		}
		
	}

}
