/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.transaction.annotation.Transactional;

import de.wicketpraxis.persistence.AbstractDao;
import de.wicketpraxis.persistence.AbstractDaoList;
import de.wicketpraxis.persistence.CriteriaFilterInterface;
import de.wicketpraxis.persistence.beans.Article;
import de.wicketpraxis.persistence.beans.User;

public class ArticleDao extends AbstractDao<Integer, Article>
{
	public static final String BEAN_ID="articleDao";

	public ArticleDao()
	{
		super(Article.class);
	}
	
	@Override
	@Transactional
	public void save(Article object)
	{
		object.setCreated(new Date());
		super.save(object);
	}
	
	public ByUser getByUser(User user)
	{
		return new ByUser(this,user);
	}
	
	public All getAll()
	{
		return new All(this);
	}
	
	public static class All extends AbstractDaoList<Integer, Article, Article>
	{
		protected All(ArticleDao dao)
		{
			super(dao);
		}
		
		@Override
		protected List<Order> getOrder()
		{
			return Arrays.asList(Order.asc("created"));
		}
	}
	
	public static class ByUser extends AbstractDaoList<Integer, Article, Article>
	{
		User _user;
		
		protected ByUser(ArticleDao dao,User user)
		{
			super(dao);
			_user=user;
		}
		
		@Override
		protected List<Order> getOrder()
		{
			return Arrays.asList(Order.asc("created"));
		}
		
		@Override
		protected List<CriteriaFilterInterface> getFilter()
		{
			return Arrays.asList((CriteriaFilterInterface) new FilterUser(_user));
		}
	}
	
	static class FilterUser implements CriteriaFilterInterface
	{
		User _user;
		
		public FilterUser(User user)
		{
			_user=user;
		}
		
		public void applyFilter(Criteria criteria)
		{
			criteria.add(Property.forName("user").eq(_user));
		}
	}
}
