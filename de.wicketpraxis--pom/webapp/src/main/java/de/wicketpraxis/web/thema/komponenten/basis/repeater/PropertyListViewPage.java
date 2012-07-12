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
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Property List Views")
public class PropertyListViewPage extends WebPage {

	public PropertyListViewPage() {
		List<Kunde> liste = Arrays.asList(new Kunde("Klaus", "Müller", 1973), new Kunde("Hans", "Meier", 1967));

		add(new PropertyListView<Kunde>("list", Model.ofList(liste)) {

			@Override
			protected void populateItem(ListItem<Kunde> item) {
				item.add(new Label("vorname"));
				item.add(new Label("name", new PropertyModel<String>(item.getModel(), "name")));
			}
		});
	}
}
