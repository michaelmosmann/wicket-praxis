/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.SetModel;

import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.UserDao;
import de.wicketpraxis.persistence.dao.UserDao.All;
import de.wicketpraxis.web.model.DaoModel;

public class UserList implements ISortableDataProvider<User,String>, /* Filter */IFilterStateLocator /* Filter Ende */
{

	UserDao _userDao;

	transient All _all;
	boolean _attached = false;

	ISortState _sortState = new SingleSortState();

	public UserList(UserDao userDao) {
		_userDao = userDao;
	}

	protected All load() {
		if (!_attached) {
			_all = _userDao.getAll();
			if (_sortState != null) {
				_all.setOrder(null, true);
				// Filter
				String mail = _filterConfig.getEMail();
				if ((mail != null) && (mail.length() > 0)) {
					_all.setLikeFilter("EMail", mail);
				}
				// Filter Ende

				String[] properties = {"id", "EMail"};
				for (String s : properties) {
					SortOrder propertySortOrder = _sortState.getPropertySortOrder(s);
					switch (propertySortOrder) {
						case ASCENDING:
							_all.setOrder(s, true);
							break;
						case DESCENDING:
							_all.setOrder(s, false);
							break;
					}
				}
			}
		}
		_attached = true;
		return _all;
	}

	@Override
	public Iterator<? extends User> iterator(long first, long count) {
		if (first>Integer.MAX_VALUE) return null;
		if ((first+count)>Integer.MAX_VALUE) return null;
		int ifirst=(int) first;
		int icount=(int) count;
		return load().getList(ifirst, icount).iterator();
	}

	public IModel<User> model(User object) {
		return new DaoModel<Integer, User>(_userDao, object);
	}

	public long size() {
		return load().getSize();
	}

	public void detach() {
		_all = null;
		_attached = false;
	}

	public ISortState getSortState() {
		return _sortState;
	}

	public void setSortState(ISortState state) {
		_sortState = state;
		detach();
	}

	// Filter
	FilterConfig _filterConfig = new FilterConfig();

	public Object getFilterState() {
		return _filterConfig;
	}

	public void setFilterState(Object state) {
		if (state instanceof FilterConfig)
			_filterConfig = (FilterConfig) state;
	}

	public static class FilterConfig implements Serializable {

		String _eMail;

		public String getEMail() {
			return _eMail;
		}

		public void setEMail(String mail) {
			_eMail = mail;
		}
	}
	// Filter - Ende

}
