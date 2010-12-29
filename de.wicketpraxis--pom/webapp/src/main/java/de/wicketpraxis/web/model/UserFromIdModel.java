/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

@Deprecated
public class UserFromIdModel extends CascadingLoadableDetachableModel<User, Integer> {

	UserDao _userDao;

	public UserFromIdModel(UserDao userDao, IModel<? extends Integer> userIdModel) {
		super(userIdModel);
		_userDao = userDao;
	}

	@Override
	protected User load(Integer parentModelData) {
		return _userDao.get(parentModelData);
	}
}
