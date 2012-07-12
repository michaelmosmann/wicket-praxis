/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.styles;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import de.wicketpraxis.apps.example.styles.header.IEConditionalHeader;

/**
 * http://960.gs/
 * 
 * @author mosmann
 * 
 */
public class Style {

	public static List<IHeaderContributor> getCss() {
		List<IHeaderContributor> ret = new ArrayList<IHeaderContributor>();
		
		ret.add(new CSS(Style.class, "grid960/reset.css", "all"));
		ret.add(new CSS(Style.class, "grid960/text.css", "all"));
		ret.add(new CSS(Style.class, "grid960/960.css", "all"));
		ret.add(new CSS(Style.class, "base.css", "all"));

		boolean specialIEHack = false;
		if (specialIEHack) {
			ret.add(IEConditionalHeader.START);
			ret.add(new CSS(Style.class, "ieOnly.css", "all"));
			ret.add(IEConditionalHeader.END);
		}
		return ret;
	}
	
	static class CSS implements IHeaderContributor {

		private ResourceReference _reference;
		private String _media;

		protected CSS(Class<?> clazz, String resource, String media) {
			_reference=new PackageResourceReference(clazz,resource);
			_media=media;
		}
		
		@Override
		public void renderHead(IHeaderResponse response) {
			response.renderCSSReference(_reference,_media);
		}
		
	}
}
