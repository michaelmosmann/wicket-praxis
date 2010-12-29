/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.converter;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Converter")
public class ConverterExamplePage extends WebPage {

	public ConverterExamplePage() {
		add(new Label("number", Model.of(1.23456d)));
		add(new Label("color", Model.of(NamedColor.BLUE)));
		add(new Label("colorConverter", Model.of(NamedColor.BLUE)) {

			@Override
			public IConverter getConverter(Class<?> type) {
				return NamedColorConverter.INSTANCE;
			}
		});
	}

	/*
	 * public final String getDefaultModelObjectAsString(final Object modelObject)
	 * {
	 * if (modelObject != null)
	 * {
	 * // Get converter
	 * final Class<?> objectClass = modelObject.getClass();
	 * 
	 * final IConverter converter = getConverter(objectClass);
	 * 
	 * // Model string from property
	 * final String modelString = converter.convertToString(modelObject, getLocale());
	 * 
	 * if (modelString != null)
	 * {
	 * // If we should escape the markup
	 * if (getFlag(FLAG_ESCAPE_MODEL_STRINGS))
	 * {
	 * // Escape HTML sensitive characters only. Not all none-ascii chars
	 * return Strings.escapeMarkup(modelString, false, false).toString();
	 * }
	 * return modelString;
	 * }
	 * }
	 * return "";
	 * }
	 */
}
