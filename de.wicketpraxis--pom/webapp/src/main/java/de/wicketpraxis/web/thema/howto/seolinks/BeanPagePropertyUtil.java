/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.seolinks;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.wicket.Application;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.PageParameters;
import org.apache.wicket.Session;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.convert.IConverter;

public class BeanPagePropertyUtil {

	public static <B> PageParameters getBeanPageParameters(B bean) {
		return new PageParameters(getParameter(bean));
	}

	protected static <B> List<String> getPublicProperties(B bean) {
		List<String> ret = new ArrayList<String>();

		Method[] methods = bean.getClass().getMethods();
		for (Method m : methods) {
			PublicProperty annotation = m.getAnnotation(PublicProperty.class);
			if (annotation != null) {
				String name = m.getName();
				if (name.startsWith("get"))
					ret.add(name.substring(3));
				else {
					if (name.startsWith("is"))
						ret.add(name.substring(2));
				}
			}
		}

		return ret;
	}

	public static <B> Map<String, Object> getParameter(B bean) {
		Map<String, Object> ret = new HashMap<String, Object>();

		Locale locale = Session.get().getLocale();
		IConverterLocator converterLocator = Application.get().getConverterLocator();

		for (String s : getPublicProperties(bean)) {
			PropertyModel<?> propertyModel = new PropertyModel(bean, s);
			IConverter converter = converterLocator.getConverter(propertyModel.getObjectClass());
			Object value = propertyModel.getObject();
			if (value != null) {
				ret.put(s, converter.convertToString(value, locale));
			}
		}
		return ret;
	}

	public static <B> void setParameter(B bean, PageParameters pageParameters) {
		Locale locale = Session.get().getLocale();
		IConverterLocator converterLocator = Application.get().getConverterLocator();

		for (String s : getPublicProperties(bean)) {
			PropertyModel<Object> propertyModel = new PropertyModel<Object>(bean, s);
			IConverter converter = converterLocator.getConverter(propertyModel.getObjectClass());
			String svalue = pageParameters.getString(s);
			if (svalue != null) {
				propertyModel.setObject(converter.convertToObject(svalue, locale));
			}
		}
	}

}
