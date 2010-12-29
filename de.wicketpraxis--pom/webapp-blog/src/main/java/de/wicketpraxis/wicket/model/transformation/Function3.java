package de.wicketpraxis.wicket.model.transformation;

import java.io.Serializable;

public interface Function3<T, M1, M2, M3> extends Serializable {

	public T apply(M1 value, M2 value2, M3 value3);
}
