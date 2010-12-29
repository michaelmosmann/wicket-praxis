/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

	public static <T extends Class<?>> Map<T, String> getClassNameMap(List<T> classes) {
		Map<T, String> ret = new HashMap<T, String>();

		for (T t : classes) {
			String title = getTitle(t);
			if (title == null) {
				String fulltitle = t.getName();
				int idx = fulltitle.lastIndexOf(".");
				if (idx != -1) {
					title = fulltitle.substring(idx + 1);
					if (ret.containsValue(title)) {
						title = fulltitle;
					}
				}
			}
			ret.put(t, title);
		}

		return ret;
	}

	public static <T extends Class<?>> String getTitle(T t) {
		String title = null;
		TitleAnnotation annotation = (TitleAnnotation) t.getAnnotation(TitleAnnotation.class);
		if (annotation != null)
			title = annotation.title();
		return title;
	}

	public static <T extends Class<?>> boolean leaveSomeSpace(T t) {
		TitleAnnotation annotation = (TitleAnnotation) t.getAnnotation(TitleAnnotation.class);
		if (annotation != null)
			return annotation.space();
		return false;
	}
}
