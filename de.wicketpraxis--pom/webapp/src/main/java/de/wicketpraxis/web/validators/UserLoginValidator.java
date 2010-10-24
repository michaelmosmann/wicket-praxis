/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.validators;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class UserLoginValidator extends AbstractFormValidator
{
	UserDao _userDao;
	FormComponent<String> _userName;
	FormComponent<String> _passWord;
	
	public UserLoginValidator(UserDao userDao,FormComponent<String> userName,FormComponent<String> passWord)
	{
		_userDao=userDao;
		_userName=userName;
		_passWord=passWord;
	}
	
	public FormComponent<?>[] getDependentFormComponents()
	{
		return new FormComponent<?>[]{_userName,_passWord};
	}

	public void validate(Form<?> form)
	{
		String userName = _userName.getConvertedInput();
		String passWord = _passWord.getConvertedInput();
		
		User user = _userDao.getByEMail(userName);
		if (user==null)
		{
			Map<String,Object> parameter=new HashMap<String, Object>();
			parameter.put("value", userName);
			error(_userName,"NotFound",parameter);
		}
		else
		{
			if (!user.isPasswordValid(passWord))
			{
				error(_passWord,"Invalid");
			}
		}
	}

}
