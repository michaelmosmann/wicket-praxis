/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

public class ColumnListViewPage extends WebPage {

	public ColumnListViewPage() {
		IModel<List<? extends Integer>> rows = Model.of(Arrays.asList(1, 2, 3));
		IModel<List<? extends String>> columns = Model.of(Arrays.asList("A", "B", "C"));
		add(new ColumnListView<Integer, String>("rows", rows, "columns", columns) {

			@Override
			protected void populateItem(ListItem<Integer> row, ListItem<String> column) {
				column.add(new Label("row", row.getModel()));
				column.add(new Label("column", column.getModel()));
			}
		});
	}
}
