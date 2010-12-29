/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.apps.example.components.layout;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class Grid extends WebMarkupContainer {

	int _columns;
	boolean _start = false;
	boolean _end = false;

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

		IModel<String> startModel = new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				return _start
						? "alpha"
						: null;
			}
		};

		IModel<String> endModel = new LoadableDetachableModel<String>() {

			@Override
			protected String load() {
				return _end
						? "omega"
						: null;
			}
		};

		add(new AttributeAppender("class", true, startModel, " "));
		add(new AttributeAppender("class", true, endModel, " "));
	}

	public int getColumns() {
		return _columns;
	}

	public Grid setColumns(int columns) {
		_columns = columns;
		return this;
	}

	public boolean isStart() {
		return _start;
	}

	public Grid setStart(boolean start) {
		_start = start;
		return this;
	}

	public boolean isEnd() {
		return _end;
	}

	public Grid setEnd(boolean end) {
		_end = end;
		return this;
	}
}
