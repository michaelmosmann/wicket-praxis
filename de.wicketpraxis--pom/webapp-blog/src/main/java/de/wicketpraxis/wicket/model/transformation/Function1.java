package de.wicketpraxis.wicket.model.transformation;

import java.io.Serializable;

public interface Function1<T,M1> extends Serializable
{
	public T apply(M1 value);
}
