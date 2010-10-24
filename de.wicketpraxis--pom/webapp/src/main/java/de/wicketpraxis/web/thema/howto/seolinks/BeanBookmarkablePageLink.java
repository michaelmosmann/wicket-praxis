/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.seolinks;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class BeanBookmarkablePageLink<T extends Page,B> extends BookmarkablePageLink<T>
{
	public BeanBookmarkablePageLink(String id, Class<T> pageClass, B bean)
	{
		super(id, pageClass,BeanPagePropertyUtil.getBeanPageParameters(bean));
	}
}