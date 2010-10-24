/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.dao;

import java.util.List;

import junit.framework.Assert;
import de.wicketpraxis.persistence.AbstractTest;
import de.wicketpraxis.persistence.beans.Article;
import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.ArticleDao.All;
import de.wicketpraxis.persistence.dao.ArticleDao.ByUser;

public class TestArticleDao extends AbstractTest
{
	public void testThingy()
	{
		ArticleDao thingyDao = getBean(ArticleDao.BEAN_ID,ArticleDao.class);
		All all = thingyDao.getAll();
		List<Article> list = all.getList(1, 100);
		
		Assert.assertEquals("Size",0,list.size());
		
	}
	
	public void testNewArticle()
	{
		UserDao userDao = getBean(UserDao.class);
		ArticleDao thingyDao = getBean(ArticleDao.class);
		
		User user=new User();
		user.setEMail("klaus@test.de");
		user.setName("Klaus");
		
		userDao.save(user);
		
		Article article=new Article();
		article.setTitle("Meins");
		article.setText("Mein teil");
		article.setUser(user);
		
		thingyDao.save(article);
		
		ByUser all = thingyDao.getByUser(user);
		
		List<Article> list = all.getList(0, 100);
		
		Assert.assertEquals("Size",1,list.size());		
		
	}
}
