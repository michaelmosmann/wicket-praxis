/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.converter;

import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

public class NamedColorConverter implements IConverter
{
	static Map<NamedColor,String> _colorStringMap=new HashMap<NamedColor, String>();
	static Map<String,NamedColor> _stringColorMap=new HashMap<String, NamedColor>();
	static
	{
		for (NamedColor c : NamedColor.values())
		{
			String s;
			switch (c)
			{
				case BLUE: s="blue"; break;
				case GREEN: s="green"; break;
				case RED: s="red"; break;
				case YELLOW: s="yellow"; break;
				default:
					throw new IllegalStateException("color not mapped: "+c);
			}
			_colorStringMap.put(c, s);
			_stringColorMap.put(s, c);
		}
	}
	
	public static final NamedColorConverter INSTANCE=new NamedColorConverter();
	
	private NamedColorConverter()
	{
		
	}
	
	public Object convertToObject(String value, Locale locale)
	{
		NamedColor namedColor = _stringColorMap.get(value);
		if (namedColor==null) throw newConversionException("color not found", value, locale);
		
		return namedColor;
	}

	public String convertToString(Object value, Locale locale)
	{
		NamedColor color=(NamedColor) value;
		
		String colorName = _colorStringMap.get(color);
		if (colorName==null) throw newConversionException("color not found", value, locale);
		
		return colorName;
	}

	protected ConversionException newConversionException(final String message, final Object value, Locale locale)
	{
		ConversionException exception = new ConversionException(message);
		exception.setSourceValue(value);
		exception.setTargetType(NamedColor.class);
		exception.setConverter(this);
		exception.setLocale(locale);
		return exception;
	}
}
