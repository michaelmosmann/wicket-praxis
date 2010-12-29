package de.wicketpraxis.wicket.model.transformation;

import org.apache.wicket.model.IModel;

public abstract class ModelSet {

	public static class Set1<M1> {

		IModel<M1> _m1;

		public Set1(IModel<M1> m1) {
			_m1 = m1;
		}

		public <T> IModel<T> apply(Function1<T, M1> function) {
			return new Transformator.Model1<T, M1>(_m1, function);
		}
	}

	public static class Set2<M1, M2> {

		IModel<M1> _m1;
		IModel<M2> _m2;

		public Set2(IModel<M1> m1, IModel<M2> m2) {
			_m1 = m1;
			_m2 = m2;
		}

		public <T> IModel<T> apply(Function2<T, M1, M2> function) {
			return new Transformator.Model2<T, M1, M2>(_m1, _m2, function);
		}
	}

	public static class Set3<M1, M2, M3> {

		IModel<M1> _m1;
		IModel<M2> _m2;
		IModel<M3> _m3;

		public Set3(IModel<M1> m1, IModel<M2> m2, IModel<M3> m3) {
			_m1 = m1;
			_m2 = m2;
			_m3 = m3;
		}

		public <T> IModel<T> apply(Function3<T, M1, M2, M3> function) {
			return new Transformator.Model3<T, M1, M2, M3>(_m1, _m2, _m3, function);
		}
	}
}
