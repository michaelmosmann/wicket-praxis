/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.LoadableDetachableModel;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.web.session.WicketPraxisSession;

public class UserFromSessionModel extends LoadableDetachableModel<User> {

	@Override
	protected User load() {
		return WicketPraxisSession.get().getUser();
	}
}
