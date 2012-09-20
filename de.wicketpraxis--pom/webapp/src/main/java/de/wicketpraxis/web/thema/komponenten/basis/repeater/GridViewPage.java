/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.GridView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Grid View")
public class GridViewPage extends WebPage {

	public GridViewPage() {
		IDataProvider<String> data = new IDataProvider<String>() {

			public Iterator<? extends String> iterator(long first, long count) {
				List<String> tempList = new ArrayList<String>();
				for (int i = 0; i < count; i++) {
					tempList.add("Position " + (i + first));
				}
				return tempList.iterator();
			}

			public IModel<String> model(String object) {
				return Model.of(object);
			}

			public long size() {
				return 25;
			}

			public void detach() { /* hier nicht nötig */
			}

		};

		final GridView<String> gridView = new GridView<String>("list", data) {

			@Override
			protected void populateItem(Item<String> item) {
				item.add(new Label("label", item.getModelObject()));
			}

			@Override
			protected void populateEmptyItem(Item<String> item) {
				item.add(new Label("label", "Leer"));
			}
		};
		gridView.setColumns(3);
		gridView.setRows(3);
		add(gridView);

		add(new Link("link") {

			@Override
			public void onClick() {
				long page = gridView.getCurrentPage() + 1;
				if (page < gridView.getPageCount())
					gridView.setCurrentPage(page);
			}
		});
	}
}
