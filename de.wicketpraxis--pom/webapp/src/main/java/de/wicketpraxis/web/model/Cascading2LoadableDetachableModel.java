/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.omg.CORBA._PolicyStub;

public abstract class Cascading2LoadableDetachableModel<M,P1,P2> extends CascadingLoadableDetachableModel<M,P1>
{
	private IModel<? extends P2> _parent2;
	
	protected Cascading2LoadableDetachableModel(IModel<? extends P1> modelParent1,IModel<? extends P2> parent2)
	{
		super(modelParent1);
		_parent2=parent2;
	}
	
	@Override
	protected void onDetach()
	{
		super.onDetach();
	  _parent2.detach();
	}

	@Override
	protected M load(P1 parentModelData)
	{
		return load(parentModelData,_parent2.getObject());
	};
	
	protected abstract M load(P1 p1,P2 p2);
}
