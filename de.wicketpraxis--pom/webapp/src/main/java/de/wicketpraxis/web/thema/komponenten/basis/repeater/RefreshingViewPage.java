/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.AbstractPageableView;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Refreshing View")
public class RefreshingViewPage extends WebPage {

	List<String> _texte = Arrays.asList("Das", "sind", "Textteile");

	public RefreshingViewPage() {
		add(new RefreshingView<String>("list") {

			@Override
			protected Iterator<IModel<String>> getItemModels() {
				return new ModelIteratorAdapter<String>(_texte.iterator()) {

					@Override
					protected IModel<String> model(String object) {
						return Model.of(object);
					}
				};
			}

			@Override
			protected void populateItem(Item<String> item) {
				item.add(new Label("label", item.getModelObject()));
			}
		});

		add(new Link("link") {

			@Override
			public void onClick() {
				_texte = Arrays.asList("Das", "ist", "ein", "anderer", "Text");
			}
		});
	}
}
