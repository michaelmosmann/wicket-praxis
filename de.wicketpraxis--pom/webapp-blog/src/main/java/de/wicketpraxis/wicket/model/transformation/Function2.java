package de.wicketpraxis.wicket.model.transformation;

import java.io.Serializable;

public interface Function2<T, M1, M2> extends Serializable {

	public T apply(M1 value, M2 value2);
}
