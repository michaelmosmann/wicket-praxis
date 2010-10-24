/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.pages;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.persistence.dao.UserDao;

public class Start extends AbstractBasePage
{
	private static final Logger _logger=LoggerFactory.getLogger(Start.class);
	
	@SpringBean(name=UserDao.BEAN_ID)
	UserDao _userDao;
	
	public Start()
	{
		getPageTitleModel().setObject("Startseite");
		
//		LoadableDetachableModel<List<User>> userModel=new LoadableDetachableModel<List<User>>()
//		{
//			@Override
//			protected List<User> load()
//			{
//				return _userDao.findAll(0, 10);
//			}
//		};
//		
//		ListView<User> userList=new ListView<User>("userList",userModel)
//		{
//			@Override
//			protected void populateItem(ListItem<User> item)
//			{
//				item.add(new Label("name",item.getModelObject().getEMail()));
//			}
//		};
//		
//		add(userList);
//		
//		add(new UserLoginPanel("userLogin"));
		
		add(new BookmarkablePageLink<RegisterNewUserPage>("registerNewUser",RegisterNewUserPage.class));
	}
}
