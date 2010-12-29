package de.wicketpraxis.web.blog.pages.migration.model.transformation;

import org.apache.wicket.model.LoadableDetachableModel;

public class RandomNumberModel extends LoadableDetachableModel<Double> {

	@Override
	protected Double load() {
		return Math.random();
	}
}
