package de.wicketpraxis.web.blog.pages.migration.model.mwst;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import de.wicketpraxis.web.blog.model.CascadingLoadableDetachableModel;

public class MwStAnteilModel extends CascadingLoadableDetachableModel<Double, Double> {

	static final Double MWST = 19.0;

	public MwStAnteilModel(IModel<? extends Double> parent) {
		super(parent);
	}

	@Override
	protected Double load(Double brutto) {
		if (brutto != null) {
			return brutto * MWST / 100.0;
		}
		return null;
	}
}
