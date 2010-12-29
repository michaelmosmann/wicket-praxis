package de.wicketpraxis.web.blog.pages.questions.data;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SomeBeanDataProvider implements ISortableDataProvider<SomeBean>, IFilterStateLocator {

	ISortState _sortState = new SingleSortState();
	SomeBeanFilter _filter = new SomeBeanFilter();

	final static int LIST_SIZE = 123;
	private List<SomeBean> _list;

	public Iterator<? extends SomeBean> iterator(int first, int count) {
		initList();

		List<SomeBean> ret = _list;
		if (ret.size() > (first + count)) {
			ret = ret.subList(first, first + count);
		}

		return ret.iterator();
	}

	public IModel<SomeBean> model(SomeBean object) {
		return Model.of(object);
	}

	public int size() {
		initList();

		return _list.size();
	}

	public void detach() {
		_list = null;
	}

	public ISortState getSortState() {
		return _sortState;
	}

	public void setSortState(ISortState state) {
		_sortState = state;
	}

	public Object getFilterState() {
		return _filter;
	}

	public void setFilterState(Object state) {
		_filter = (SomeBeanFilter) state;
	}

	private void initList() {
		if (_list == null) {
			final int nameSort;
			final int alterSort;
			if (_sortState != null) {
				nameSort = _sortState.getPropertySortOrder("name");
				alterSort = _sortState.getPropertySortOrder("alter");
			} else {
				nameSort = ISortState.NONE;
				alterSort = ISortState.NONE;
			}

			_list = getSortedList(nameSort, alterSort, _filter);
		}
	}

	private List<SomeBean> getSortedList(final int nameSort, final int alterSort, SomeBeanFilter filter) {
		List<SomeBean> result = SomeBeanGenerator.getBeans(LIST_SIZE, filter);

		Collections.sort(result, new Comparator<SomeBean>() {

			public int compare(SomeBean o1, SomeBean o2) {
				int compName = o1.getName().compareTo(o2.getName());
				int compAlter = new Integer(o1.getAlter()).compareTo(o2.getAlter());
				switch (nameSort) {
					case ISortState.NONE:
						compName = 0;
						break;
					case ISortState.DESCENDING:
						compName = -compName;
						break;
				}
				switch (alterSort) {
					case ISortState.NONE:
						compAlter = 0;
						break;
					case ISortState.DESCENDING:
						compAlter = -compAlter;
						break;
				}
				if (compName != 0)
					return compName;
				return compAlter;
			}
		});

		return result;
	}

}
