/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class AbstractDaoList<K extends Serializable,T extends DoInterface<K>,R> //implements DaoListInterface<R>
{
	AbstractDao<K, T> _dao;
	
	protected AbstractDaoList(AbstractDao<K, T> dao)
	{
		_dao=dao;
	}
	
	public List<R> getList(Integer offset,Integer max)
	{
		List<R> ret=null;
		
		Criteria criteria = _dao.getCriteria();
		if (offset!=null) criteria.setFirstResult(offset);
		if (max!=null) criteria.setMaxResults(max);
		
		for (Order order : getOrder()) criteria.addOrder(order);
		for (CriteriaFilterInterface filter: getFilter()) filter.applyFilter(criteria);
		
		ret=criteria.list();
		
		return ret;
	}
	
	public int getSize()
	{
		int ret=0;
		
		Criteria criteria = _dao.getCriteria();
		for (CriteriaFilterInterface filter: getFilter()) filter.applyFilter(criteria);
		criteria.setProjection(Projections.rowCount());
	
		ret=(Integer) criteria.uniqueResult();
		
		return ret;
	}
	
	protected List<Order> getOrder()
	{
		return new ArrayList<Order>();
	}
	
	protected List<CriteriaFilterInterface> getFilter()
	{
		return new ArrayList<CriteriaFilterInterface>();
	}
}
