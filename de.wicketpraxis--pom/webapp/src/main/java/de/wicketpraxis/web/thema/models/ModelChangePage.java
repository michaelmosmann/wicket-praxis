/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class ModelChangePage extends WebPage {

	public ModelChangePage() {
		final IModel<Integer> message = Model.of(0);

		add(new Label("message", message));

		add(new Link<Integer>("changeModel", message) {

			@Override
			public void onClick() {
				setModelObject(getModelObject() + 1);
			}
		});

		add(new Link<Integer>("changeModelDirect", message) {

			@Override
			public void onClick() {
				getModel().setObject(getModel().getObject() + 1);
			}
		});

		add(new Link("doNothing") {

			@Override
			public void onClick() {

			}
		});
	}
}
