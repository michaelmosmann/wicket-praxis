package de.wicketpraxis.web.blog.pages;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;


public class PageLinksPanel extends Panel {

	public PageLinksPanel(String id, List<Class<? extends WebPage>> pages) {
		super(id);
		
		add(new ListView<Class<? extends WebPage>>("list", pages) {

			@Override
			protected void populateItem(ListItem<Class<? extends WebPage>> item) {
				BookmarkablePageLink<WebPage> link = new BookmarkablePageLink<WebPage>("link", item.getModelObject());
				link.add(new Label("name", item.getModelObject().getSimpleName()));
				item.add(link);
			}
		});

	}

}
