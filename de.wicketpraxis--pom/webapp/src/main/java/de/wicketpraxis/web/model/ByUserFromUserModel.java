/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.ArticleDao;
import de.wicketpraxis.persistence.dao.ArticleDao.ByUser;

public class ByUserFromUserModel extends CascadingLoadableDetachableModel<ByUser, User>
{
	ArticleDao _articleDao;
	
	public ByUserFromUserModel(ArticleDao articleDao, IModel<? extends User> userModel)
	{
		super(userModel);
		_articleDao=articleDao;
	}
	
	@Override
	protected ByUser load(User parentModelData)
	{
		return _articleDao.getByUser(parentModelData);
	}
}
