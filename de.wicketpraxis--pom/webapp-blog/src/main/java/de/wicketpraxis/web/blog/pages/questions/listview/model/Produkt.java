package de.wicketpraxis.web.blog.pages.questions.listview.model;

import java.io.Serializable;

public class Produkt implements Serializable {

	int _id;

	String _name;

	boolean _aktiv;

	public Produkt() {
		// TODO Auto-generated constructor stub
	}

	public Produkt(int id, String name, boolean aktiv) {
		_id = id;
		_name = name;
		_aktiv = aktiv;
	}

	public void setValuesFrom(Produkt old) {
		_id = old._id;
		_name = old._name;
		_aktiv = old._aktiv;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean isAktiv() {
		return _aktiv;
	}

	public void setAktiv(boolean aktiv) {
		_aktiv = aktiv;
	}

}
