/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.pages.user;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.components.articles.ArticleListPanel;
import de.wicketpraxis.web.components.articles.NewArticlePanel;
import de.wicketpraxis.web.model.UserFromIdModel;
import de.wicketpraxis.web.model.UserFromSessionModel;
import de.wicketpraxis.web.model.UserIdFromSessionModel;

public class UserStartPage extends AbstractUserBasePage
{
	@SpringBean(name=UserDao.BEAN_ID)
	UserDao _userDao;
	
	public UserStartPage()
	{		
//		UserIdFromSessionModel userIdFromSession=new UserIdFromSessionModel();
//		
//		UserFromIdModel userFromId=new UserFromIdModel(_userDao,userIdFromSession);
		
		UserFromSessionModel userFrom=new UserFromSessionModel();
		
		add(new FeedbackPanel("feedback",new ContainerFeedbackMessageFilter(this)));
		
		add(new ArticleListPanel("thingies",userFrom));

		add(new NewArticlePanel("newThingy",userFrom));
	}
}
