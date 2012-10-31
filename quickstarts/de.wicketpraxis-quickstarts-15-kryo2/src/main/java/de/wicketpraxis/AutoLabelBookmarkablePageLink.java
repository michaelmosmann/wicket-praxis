package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

public class AutoLabelBookmarkablePageLink<T extends WebPage> extends BookmarkablePageLink<T>
{
	public AutoLabelBookmarkablePageLink(String id, Class<T> pageClass)
	{
		super(id, pageClass);

		setBody(Model.of(pageClass.getSimpleName()));
	}

	public static <T extends WebPage> AbstractLink with(String id, Class<T> pageType)
	{
		return new AutoLabelBookmarkablePageLink<T>(id, pageType);
	}

}
