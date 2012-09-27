package de.wicketpraxis.web.blog.pages.examples.models.pagination;

import java.io.Serializable;
import java.util.List;

import de.wicketpraxis.wicket.model.transformation.Function2;


public class ModelCache<T extends Serializable,S> implements IModelSource<T> {

	private final IModelSource<S> _source;
	private final Function2<T, Long, S> _transformation;

	public ModelCache(IModelSource<S> source,Function2<T, Long, S> transformation) {
		_source = source;
		_transformation = transformation;
	}
	
	@Override
	public List<T> get(Range<T> range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long max() {
		return _source.max();
	}

	
}
