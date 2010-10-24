package de.wicketpraxis.wicket.model.transformation;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class Transformator<T> extends LoadableDetachableModel<T>
{
	IModel<?>[] _subModels;
	
	protected Transformator(IModel<?> ... subModels)
  {
		_subModels=subModels;
  }
	
	@Override
	protected void onDetach()
	{
		for (IModel<?> m : _subModels)
		{
			m.detach();
		}
	}
	
	public static class Model1<T,M1> extends Transformator<T>
	{
		IModel<M1> _m1;
		Function1<T, M1> _function;
		
		public Model1(IModel<M1> m1, Function1<T, M1> function)
    {
	    super(m1);
	    
	    _m1=m1;
	    _function=function;
    }
		
		@Override
		protected T load()
		{
		  return _function.apply(_m1.getObject());
		}
	}
	
	public static class Model2<T,M1,M2> extends Transformator<T>
	{
		IModel<M1> _m1;
		IModel<M2> _m2;
		Function2<T, M1, M2> _function;
		
		public Model2(IModel<M1> m1, IModel<M2> m2, Function2<T, M1, M2> function)
    {
	    super(m1,m2);
	    
	    _m1=m1;
	    _m2=m2;
	    _function=function;
    }
		
		@Override
		protected T load()
		{
		  return _function.apply(_m1.getObject(),_m2.getObject());
		}
	}

	public static class Model3<T,M1,M2,M3> extends Transformator<T>
	{
		IModel<M1> _m1;
		IModel<M2> _m2;
		IModel<M3> _m3;
		Function3<T, M1, M2, M3> _function;
		
		public Model3(IModel<M1> m1, IModel<M2> m2, IModel<M3> m3, Function3<T, M1, M2, M3> function)
    {
	    super(m1,m2,m3);
	    
	    _m1=m1;
	    _m2=m2;
	    _m3=m3;
	    _function=function;
    }
		
		@Override
		protected T load()
		{
		  return _function.apply(_m1.getObject(),_m2.getObject(),_m3.getObject());
		}
	}
}
