package de.wicketpraxis.web.blog.pages.examples.models.pagination;

import java.util.List;

import org.apache.wicket.model.AbstractReadOnlyModel;


public class CachedWindowListModel<T> extends AbstractReadOnlyModel<List<? extends T>>{

	@Override
	public List<? extends T> getObject() {
		return null;
	}

}
