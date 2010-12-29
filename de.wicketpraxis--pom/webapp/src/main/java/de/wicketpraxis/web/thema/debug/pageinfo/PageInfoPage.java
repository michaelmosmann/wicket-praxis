/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug.pageinfo;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.debug.PageView;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class PageInfoPage extends WebPage {

	public PageInfoPage() {
		add(new ListView<String>("dummies", Arrays.asList("Das", "ist", "ein", "Test")) {

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("dummy", item.getModel()));
			}
		});

		add(new PageView("componentTree", this));
	}
}
