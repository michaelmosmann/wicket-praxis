/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.mount;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.target.coding.HybridUrlCodingStrategy;
import org.apache.wicket.request.target.coding.QueryStringUrlCodingStrategy;

public class PageMount {

	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this) {
		PageMount.mountPages(_this);

		_this.getApplicationSettings().setPageExpiredErrorPage(SessionTimeoutPage.class);
	}

	/*
	 * Code in Application
	 */

	public static void mountPages(WebApplication app) {
		mountQueryString(app, MountedPage.class);
		mountHybrid(app, SubMountedPage.class);
	}

	private static void mountQueryString(WebApplication app, Class<? extends Page> page) {
		app.mount(new QueryStringUrlCodingStrategy(getPath(page), page));
	}

	// funktioniert besser mit session timeout's
	private static void mountHybrid(WebApplication app, Class<? extends Page> page) {
		app.mount(new HybridUrlCodingStrategy(getPath(page), page, true));
	}

	private static String getPath(Class<? extends Page> page) {
		StringBuilder sb = new StringBuilder();
		getPath(sb, page);
		return sb.toString();
	}

	private static void getPath(StringBuilder sb, Class<?> page) {
		MountPath mountAnnotation = page.getAnnotation(MountPath.class);
		if (mountAnnotation != null) {
			getPath(sb, mountAnnotation.Parent());
			sb.append(mountAnnotation.Path());
		}
	}
}
