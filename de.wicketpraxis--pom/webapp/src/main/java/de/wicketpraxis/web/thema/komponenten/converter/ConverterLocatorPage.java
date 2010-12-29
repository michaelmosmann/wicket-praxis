/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.converter;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.MultiLineLabel;

public class ConverterLocatorPage extends WebPage {

	public ConverterLocatorPage() {
		String code = "		@Override\n		protected IConverterLocator newConverterLocator()\n		{\n			return new CustomConverterLocator(super.newConverterLocator());\n		}\n";
		/*
		 * @Override
		 * protected IConverterLocator newConverterLocator()
		 * {
		 * return new CustomConverterLocator(super.newConverterLocator());
		 * }
		 */
		add(new MultiLineLabel("code", code));
	}
}
