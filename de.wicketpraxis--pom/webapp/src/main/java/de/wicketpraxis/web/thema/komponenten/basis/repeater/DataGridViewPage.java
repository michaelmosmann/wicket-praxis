/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class DataGridViewPage extends WebPage {

	public DataGridViewPage() {
		List<ICellPopulator<Kunde>> cells = new ArrayList<ICellPopulator<Kunde>>();
		cells.add(new PropertyPopulator("Vorname"));
		cells.add(new PropertyPopulator("Name"));
		cells.add(new ICellPopulator<Kunde>() {

			public void populateItem(Item<ICellPopulator<Kunde>> cellItem, String componentId, IModel<Kunde> rowModel) {
				Kunde kunde = rowModel.getObject();
				cellItem.add(new Label(componentId, Model.of(kunde.getGeburtsjahr())));
			}

			public void detach() {

			}
		});

		List<Kunde> liste = new ArrayList<Kunde>();
		for (int i = 1; i < 6; i++) {
			liste.add(new Kunde("Ablrecht", "von Klausewitz der " + i + ".", 1381 + i * 69));
		}
		ListDataProvider<Kunde> data = new ListDataProvider<Kunde>(liste);

		final DataGridView<Kunde> datagrid = new DataGridView<Kunde>("list", cells, data);
		datagrid.setRowsPerPage(3);
		add(datagrid);

		add(new Link("link") {

			@Override
			public void onClick() {
				int page = datagrid.getCurrentPage() + 1;
				if (page < datagrid.getPageCount())
					datagrid.setCurrentPage(page);
			}
		});
	}
}
