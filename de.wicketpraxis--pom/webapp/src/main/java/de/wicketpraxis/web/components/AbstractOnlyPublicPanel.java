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

public class AbstractOnlyPublicPanel extends Panel {

	public AbstractOnlyPublicPanel(String id) {
		super(id);
	}

	public AbstractOnlyPublicPanel(String id, IModel<?> model) {
		super(id, model);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		setVisible(!WicketPraxisSession.get().isUserLogin());
	}
}
