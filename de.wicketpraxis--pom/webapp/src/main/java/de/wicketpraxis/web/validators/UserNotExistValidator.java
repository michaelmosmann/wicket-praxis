/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.validators;

import java.util.HashMap;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

import de.wicketpraxis.persistence.dao.UserDao;

public class UserNotExistValidator extends AbstractValidator<String> {

	UserDao _userDao;

	public UserNotExistValidator(UserDao userDao) {
		_userDao = userDao;
	}

	@Override
	protected void onValidate(IValidatable<String> validatable) {
		if (_userDao.getByEMail(validatable.getValue()) != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("value", validatable.getValue());
			error(validatable, "Exist", map);
		}
	}

}
