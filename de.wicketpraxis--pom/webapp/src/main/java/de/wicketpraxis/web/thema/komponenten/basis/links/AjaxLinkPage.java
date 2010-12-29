/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class AjaxLinkPage extends WebPage {

	private Label _message;

	public AjaxLinkPage() {
		_message = new Label("message", "Jetzt ist es " + new Date());
		_message.setOutputMarkupId(true);
		add(_message);

		add(new AjaxLink("ajax") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				_message.setDefaultModelObject("Ajax Link geklickt (" + new Date() + ")");
				if (target != null) {
					target.addComponent(_message);
				}
			}
		});

		add(new IndicatingAjaxLink("ajax2") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				timeConsumingTask();

				_message.setDefaultModelObject("Ajax Link geklickt (" + new Date() + ")");
				target.addComponent(_message);
			}
		});
	}

	private void timeConsumingTask() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
