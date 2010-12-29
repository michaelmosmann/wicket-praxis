/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.css.layout;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class Grid extends WebMarkupContainer {

	int _columns;

	public Grid(String id, int columns) {
		super(id);

		_columns = columns;

		IModel<String> columnModel = new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				return "grid_" + _columns;
			}
		};

		add(new AttributeAppender("class", true, columnModel, " "));
	}

	public int getColumns() {
		return _columns;
	}

	public Grid setColumns(int columns) {
		_columns = columns;
		return this;
	}
}
