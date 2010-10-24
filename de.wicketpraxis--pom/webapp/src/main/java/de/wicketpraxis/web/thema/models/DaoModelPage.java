/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.web.model.DaoModel;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Dao Model")
public class DaoModelPage extends WebPage
{
	@SpringBean
	UserDao _userDao;
	
	public DaoModelPage()
	{
		User user = _userDao.getByEMail("test@wicket-praxis.de");
		
		DaoModel<Integer, User> model=new DaoModel<Integer, User>(_userDao,user);
		
		setDefaultModel(new CompoundPropertyModel<User>(model));
		
//		PropertyModel<String> modelEmail=new PropertyModel<String>(model,"EMail");
//		PropertyModel<String> modelName=new PropertyModel<String>(model,"Name");
		
		add(new Label("eMail"));
		add(new Label("name"));
		
//		IModel<String> message = new LoadableDetachableModel<String>()
//		{
//			@Override
//			protected String load()
//			{
//				return "Jetzt ist " + new Date();
//			}
//		};
//
//		add(new Label("message", message));
//
//		add(new Link("doNothing")
//		{
//			@Override
//			public void onClick()
//			{
//				
//			}
//		});

	}
}
