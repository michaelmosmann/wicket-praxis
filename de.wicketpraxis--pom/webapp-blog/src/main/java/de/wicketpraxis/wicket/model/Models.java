package de.wicketpraxis.wicket.model;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.wicket.model.transformation.ModelSet;

public abstract class Models {

	public static <T, M1> ModelSet.Set1<M1> on(IModel<M1> model) {
		return new ModelSet.Set1<M1>(model);
	}

	public static <T, M1, M2> ModelSet.Set2<M1, M2> on(IModel<M1> model, IModel<M2> model2) {
		return new ModelSet.Set2<M1, M2>(model, model2);
	}

	public static <T, M1, M2, M3> ModelSet.Set3<M1, M2, M3> on(IModel<M1> model, IModel<M2> model2, IModel<M3> model3) {
		return new ModelSet.Set3<M1, M2, M3>(model, model2, model3);
	}
}
