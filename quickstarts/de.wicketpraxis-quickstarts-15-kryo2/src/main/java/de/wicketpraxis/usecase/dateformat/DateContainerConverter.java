package de.wicketpraxis.usecase.dateformat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.util.convert.converter.AbstractConverter;
import org.apache.wicket.util.string.Strings;

public class DateContainerConverter<T extends AbstractDateContainer> extends AbstractConverter<T>
{
	private final Class<T> containerType;
	private final String pattern;
	private Constructor<T> constructor;

	public DateContainerConverter(Class<T> containerType,String pattern)
	{
		this.containerType = containerType;
		this.pattern = pattern;
		try
		{
			constructor = containerType.getConstructor(Date.class);
		}
		catch (SecurityException e)
		{
			throw new WicketRuntimeException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new WicketRuntimeException(e);
		}
	}
	
	/**
	 * @see org.apache.wicket.util.convert.IConverter#convertToObject(java.lang.String,Locale)
	 */
	@Override
	public T convertToObject(final String value, final Locale locale)
	{
		if ((value == null) || Strings.isEmpty(value))
		{
			return null;
		}
		else
		{
			try
			{
				return constructor.newInstance(parse(getDateFormat(locale), value, locale));
			}
			catch (IllegalArgumentException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (InstantiationException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (IllegalAccessException e)
			{
				throw new WicketRuntimeException(e);
			}
			catch (InvocationTargetException e)
			{
				throw new WicketRuntimeException(e);
			}
		}
	}

	/**
	 * @see org.apache.wicket.util.convert.IConverter#convertToString(Object, java.util.Locale)
	 */
	@Override
	public String convertToString(final T value, final Locale locale)
	{
		final Format dateFormat = getDateFormat(locale);
		if (dateFormat != null)
		{
			return dateFormat.format(value.getValue());
		}
		return value.toString();
	}

	private Format getDateFormat(Locale locale)
	{
		if (locale == null)
		{
			locale = Locale.getDefault();
		}
		return new SimpleDateFormat(this.pattern, locale);
	}

	@Override
	protected Class<T> getTargetType()
	{
		return containerType;
	}

}
