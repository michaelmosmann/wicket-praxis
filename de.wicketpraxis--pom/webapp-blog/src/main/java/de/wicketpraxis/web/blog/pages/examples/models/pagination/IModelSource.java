package de.wicketpraxis.web.blog.pages.examples.models.pagination;

import java.util.List;

public interface IModelSource<T> {

	List<T> get(Range<T> range);
	long max();
}
