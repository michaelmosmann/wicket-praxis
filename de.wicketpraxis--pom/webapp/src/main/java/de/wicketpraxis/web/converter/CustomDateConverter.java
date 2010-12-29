/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.converter;

import java.text.DateFormat;
import java.util.Locale;

import org.apache.wicket.util.convert.converters.DateConverter;

public class CustomDateConverter extends DateConverter {

	int _dateStyle;
	Integer _timeStyle;

	public CustomDateConverter(int dateStyle) {
		_dateStyle = dateStyle;
	}

	public CustomDateConverter(int dateStyle, int timeStyle) {
		_dateStyle = dateStyle;
		_timeStyle = timeStyle;
	}

	@Override
	public DateFormat getDateFormat(Locale locale) {
		if (locale == null)
			locale = Locale.getDefault();

		if (_timeStyle != null)
			return DateFormat.getDateTimeInstance(_dateStyle, _timeStyle, locale);
		else
			return DateFormat.getDateInstance(_dateStyle, locale);
	}
}
