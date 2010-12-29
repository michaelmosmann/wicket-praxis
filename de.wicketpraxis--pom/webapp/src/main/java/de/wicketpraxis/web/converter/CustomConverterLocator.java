/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.converter;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.IConverterLocator;
import org.apache.wicket.util.convert.IConverter;

import de.wicketpraxis.web.thema.komponenten.converter.NamedColor;
import de.wicketpraxis.web.thema.komponenten.converter.NamedColorConverter;

public class CustomConverterLocator implements IConverterLocator {

	IConverterLocator _fallback;

	Map<Class<?>, IConverter> _customMap = new HashMap<Class<?>, IConverter>();
	{
		_customMap.put(NamedColor.class, NamedColorConverter.INSTANCE);
	}

	public CustomConverterLocator(IConverterLocator fallback) {
		_fallback = fallback;
	}

	public IConverter getConverter(Class<?> type) {
		IConverter ret = _customMap.get(type);
		if (ret == null)
			ret = _fallback.getConverter(type);
		return ret;
	}
}
