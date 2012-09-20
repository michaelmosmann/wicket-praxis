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

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

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
			ret.add(new CSS(Style.class, "ieOnly.css", "all","IE"));
		}
		return ret;
	}
	
	static class CSS implements IHeaderContributor {

		private ResourceReference _reference;
		private String _media;
		private String _condition;

		protected CSS(Class<?> clazz, String resource, String media) {
			this(clazz,resource,media,null);
		}
		
		protected CSS(Class<?> clazz, String resource, String media, String condition) {
			_reference=new PackageResourceReference(clazz,resource);
			_media=media;
			_condition=condition;
		}
		
		@Override
		public void renderHead(IHeaderResponse response) {
			response.render(new CssReferenceHeaderItem(_reference,new PageParameters(),_media,_condition));
		}
		
	}
}
