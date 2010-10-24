/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.dynamic;

import java.io.Serializable;
import java.util.Map;

import org.apache.wicket.model.IModel;

public class MapPropertyModel<V extends Serializable> implements IModel<V>
{
	IModel<? extends Map<String,Serializable>> _model;
	String _property;
	
	public MapPropertyModel(IModel<? extends Map<String, Serializable>> model, String property)
	{
		_model = model;
		_property = property;
	}

	public V getObject()
	{
		return (V) _model.getObject().get(_property);
	}

	public void setObject(V object)
	{
		_model.getObject().put(_property,object);
	}

	public void detach()
	{
		_model.detach();
	}
	
}
