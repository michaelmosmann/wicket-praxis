/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class Cascading3LoadableDetachableModel<M, P1, P2, P3> extends
		Cascading2LoadableDetachableModel<M, P1, P2> {

	private IModel<? extends P3> _parent3;

	protected Cascading3LoadableDetachableModel(IModel<? extends P1> modelParent1, IModel<? extends P2> modelParent2,
			IModel<? extends P3> parent3) {
		super(modelParent1, modelParent2);
		_parent3 = parent3;
	}

	@Override
	protected void onDetach() {
		super.onDetach();
		_parent3.detach();
	}

	@Override
	protected M load(P1 p1, P2 p2) {
		return load(p1, p2, _parent3.getObject());
	};

	protected abstract M load(P1 p1, P2 p2, P3 p3);
}
