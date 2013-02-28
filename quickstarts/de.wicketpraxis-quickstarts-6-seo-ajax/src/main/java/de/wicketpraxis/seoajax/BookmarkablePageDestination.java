package de.wicketpraxis.seoajax;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.RequestUtils;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BookmarkablePageDestination<T extends WebPage> {

	private final Class<? extends T> _pageClass;
	private final PageParameters _pageParameters;

	public BookmarkablePageDestination(Class<? extends T> pageClass, PageParameters pageParameters) {
		_pageClass = pageClass;
		_pageParameters = new PageParameters(pageParameters);
	}

	public Class<? extends T> getPageClass() {
		return _pageClass;
	}

	public PageParameters getPageParameters() {
		// not immutable, so we have to copy
		return new PageParameters(_pageParameters);
	}

	public String asUrl() {
		return RequestCycle.get().urlFor(_pageClass, _pageParameters).toString();
	}

	public static <T extends WebPage> BookmarkablePageDestination<T> with(Class<T> pageClass) {
		return new BookmarkablePageDestination<T>(pageClass, new PageParameters());
	}

	public static <T extends WebPage> BookmarkablePageDestination<T> with(Class<T> pageClass,
			PageParameters pageParameters) {
		return new BookmarkablePageDestination<T>(pageClass, pageParameters);
	}
}
