/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

public abstract class ColumnListView<R, C> extends ListView<R> {

	IModel<? extends List<? extends C>> _columns;
	String _columnId;

	public ColumnListView(String id, IModel<? extends List<? extends R>> rows, String columnId,
			IModel<? extends List<? extends C>> columns) {
		super(id, rows);
		_columnId = columnId;
		_columns = columns;
	}

	@Override
	protected void populateItem(final ListItem<R> row) {
		row.add(new ListView<C>(_columnId, _columns) {

			@Override
			protected void populateItem(ListItem<C> column) {
				ColumnListView.this.populateItem(row, column);
			}
		});
	}

	protected abstract void populateItem(ListItem<R> row, ListItem<C> column);
}
