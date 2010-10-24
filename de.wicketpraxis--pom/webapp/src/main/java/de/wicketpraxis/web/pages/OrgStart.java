/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.pages;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;

public class OrgStart extends WebPage
{
	@SpringBean(name=UserDao.BEAN_ID)
	UserDao _userDao;
	
	public OrgStart()
	{
		LoadableDetachableModel<List<User>> userModel=new LoadableDetachableModel<List<User>>()
		{
			@Override
			protected List<User> load()
			{
				return _userDao.findAll(0, 10);
			}
		};
		
		ListView<User> userList=new ListView<User>("userList",userModel)
		{
			@Override
			protected void populateItem(ListItem<User> item)
			{
				item.add(new Label("name",item.getModelObject().getEMail()));
			}
		};
		
		add(userList);
	}

}
