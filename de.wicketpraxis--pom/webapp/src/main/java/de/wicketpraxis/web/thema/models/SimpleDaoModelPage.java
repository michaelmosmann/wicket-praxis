/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.model.CascadingLoadableDetachableModel;
import de.wicketpraxis.web.model.DaoModel;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Simple Dao Model",space=true)
public class SimpleDaoModelPage extends WebPage
{
	@SpringBean
	UserDao _userDao;
	
	public SimpleDaoModelPage()
	{
		User user = _userDao.getByEMail("test@wicket-praxis.de");
		
		DaoModel<Integer, User> model=new DaoModel<Integer, User>(_userDao,user!=null ? user.getId() : null);
		
		IModel<String> nameModel = new CascadingLoadableDetachableModel<String, User>(model)
		{
			@Override
			protected String load(User p)
			{
				if (p!=null) return p.getName();
				return null;
			}
		};
		
		add(new Label("name", nameModel));

		add(new Link("doNothing")
		{
			@Override
			public void onClick()
			{
				
			}
		});
	}
}
