/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import de.wicketpraxis.persistence.AbstractDao;
import de.wicketpraxis.persistence.AbstractDaoList;
import de.wicketpraxis.persistence.CriteriaFilterInterface;
import de.wicketpraxis.persistence.beans.User;

public class UserDao extends AbstractDao<Integer, User>
{
	public static final String BEAN_ID="userDao";
	
	public UserDao()
	{
		super(User.class);
	}

	public User getByEMail(String email)
	{
		return (User) getCriteria().add(Property.forName("EMail").eq(email)).uniqueResult();
		
	}
	
	public All getAll()
	{
		return new All(this);
	}
	
	public static class All extends AbstractDaoList<Integer, User, User>
	{
		String _sort;
		boolean _asc;
		
		protected All(UserDao userDao)
		{
			super(userDao);
		}

		@Override
		protected List<Order> getOrder()
		{
			ArrayList<Order> ret = new ArrayList<Order>();
			if (_sort!=null)
			{
				ret.add(_asc ? Order.asc(_sort) : Order.desc(_sort));
			}
			return ret;
		}
		
		public void setOrder(String column,boolean asc)
		{
			_sort=column;
			_asc=asc;
		}
		
		// filtered list
		Map<String,CriteriaFilterInterface> _filterMap=new HashMap<String, CriteriaFilterInterface>();
		
		public void setLikeFilter(String property,String value)
		{
			if (property!=null)
			{
				if (value!=null) _filterMap.put(property, new LikeFilter(property,value));
				else _filterMap.remove(property);
			}
		}
		
		@Override
		protected List<CriteriaFilterInterface> getFilter()
		{
			return new ArrayList<CriteriaFilterInterface>(_filterMap.values());
		}
	}
	
	static class LikeFilter implements CriteriaFilterInterface
	{
		String _property;
		String _value;
		
		public LikeFilter(String property,String value)
		{
			_property=property;
			_value=value.replace('*', '%');
		}
		
		public void applyFilter(Criteria criteria)
		{
			criteria.add(Restrictions.like(_property, _value));
		}
	}
}
