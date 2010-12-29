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

import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.IHeaderContributor;

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
		ret.add(CSSPackageResource.getHeaderContribution(Style.class, "grid960/reset.css", "all"));
		ret.add(CSSPackageResource.getHeaderContribution(Style.class, "grid960/text.css", "all"));
		ret.add(CSSPackageResource.getHeaderContribution(Style.class, "grid960/960.css", "all"));
		ret.add(CSSPackageResource.getHeaderContribution(Style.class, "base.css", "all"));

		boolean specialIEHack = false;
		if (specialIEHack) {
			ret.add(IEConditionalHeader.START);
			ret.add(CSSPackageResource.getHeaderContribution(Style.class, "ieOnly.css", "all"));
			ret.add(IEConditionalHeader.END);
		}
		return ret;
	}
}
