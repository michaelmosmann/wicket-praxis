/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.ajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class SimpleAjaxPage extends WebPage {

	private Label _labelRefresh;
	private Label _labelNoRefresh;

	public SimpleAjaxPage() {
		
		
		_labelRefresh = new Label("refresh", "Bin gleich weg.");
		_labelRefresh.setOutputMarkupId(true);
		add(_labelRefresh);

		_labelNoRefresh = new Label("noRefresh", "Bin noch da.");
		add(_labelNoRefresh);

		add(new AjaxLink("link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				_labelRefresh.setDefaultModelObject("neuer Text");
				_labelNoRefresh.setDefaultModelObject("...auch hier neuer Text");

				target.add(_labelRefresh);
			}
		});

	}
}
