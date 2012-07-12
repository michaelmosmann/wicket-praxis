/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.components;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import de.wicketpraxis.web.session.WicketPraxisSession;

public abstract class AbstractLoggedPanel extends Panel {

	public AbstractLoggedPanel(String id) {
		super(id);
	}

	public AbstractLoggedPanel(String id, IModel<?> model) {
		super(id, model);
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();
		setVisible(WicketPraxisSession.get().isUserLogin());
	}
}
