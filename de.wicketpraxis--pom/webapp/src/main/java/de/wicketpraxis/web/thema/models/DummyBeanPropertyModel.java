/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import java.io.Serializable;

import org.apache.wicket.model.IModel;

public class DummyBeanPropertyModel<T extends Serializable> implements IModel<T> {

	public enum PropertySelector {
		NAME,
		ALTER,
	};

	DummyBean _bean;
	PropertySelector _selector;

	public DummyBeanPropertyModel(DummyBean bean, PropertySelector selector) {
		_bean = bean;
		_selector = selector;
	}

	public T getObject() {
		switch (_selector) {
			case NAME:
				return (T) _bean.getName();
			case ALTER:
				return (T) new Integer(_bean.getAlter());
		}
		return null;
	}

	public void setObject(T object) {
		switch (_selector) {
			case NAME:
				_bean.setName((String) object);
				break;
			case ALTER:
				Integer alter = (Integer) object;
				_bean.setAlter(alter.intValue());
				break;
		}
	}

	public void detach() {
	}
}
