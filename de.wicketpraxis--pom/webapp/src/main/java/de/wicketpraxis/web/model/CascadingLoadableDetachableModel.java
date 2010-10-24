/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;


public abstract class CascadingLoadableDetachableModel<M,P> extends LoadableDetachableModel<M>
{
	private IModel<? extends P> _parent;
	
	public CascadingLoadableDetachableModel(IModel<? extends P> parent)
	{
		super();
		_parent=parent;
	}
	
	@Override
	protected void onDetach()
	{
	  _parent.detach();
	}

	@Override
  final protected M load()
  {
	  P result=_parent.getObject();
		M ret=load(result);
	  return ret;
  }

	protected abstract M load(P p);

}
