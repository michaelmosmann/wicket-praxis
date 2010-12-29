/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.navigation;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.apps.example.pages.Start;

public class PageNavigationCallback extends AbstractNavigationCallback {

	String _name;
	Class<? extends Page> _page;

	public PageNavigationCallback(String name, Class<? extends Page> page) {
		_name = name;
		_page = page;
	}

	public String getName() {
		return _name;
	}

	public boolean isActive(Page page) {
		if (page.getClass() == _page)
			return true;
		return false;
	}

	public void onClick(Page page) {
		page.setResponsePage(_page);
	}

	public Class<? extends Page> getPage() {
		return _page;
	}

	public static int findCallback(List<NavigationCallbackInterface> list, Class<? extends Page> page) {
		int idx = 0;
		int pos = -1;
		for (NavigationCallbackInterface n : list) {
			if (n instanceof PageNavigationCallback) {
				if (((PageNavigationCallback) n).getPage() == page) {
					pos = idx;
					break;
				}
			}
			idx++;
		}
		return pos;
	}

	public static boolean replaceCallback(List<NavigationCallbackInterface> ret, Class<? extends Page> page,
			NavigationCallbackInterface callback) {
		int pos = findCallback(ret, page);
		if (pos != -1) {
			ret.set(pos, callback);
			return true;
		}
		return false;
	}
}
