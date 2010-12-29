/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import java.io.Serializable;

public class DummyBean implements Serializable {

	String _name;

	int _alter;

	SubBean _sub;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getAlter() {
		return _alter;
	}

	public void setAlter(int alter) {
		_alter = alter;
	}

	public void setSub(SubBean sub) {
		_sub = sub;
	}

	public SubBean getSub() {
		return _sub;
	}

	@Override
	public String toString() {
		return "Name: " + _name + ", Alter: " + _alter + " (" + _sub + ")";
	}
}
