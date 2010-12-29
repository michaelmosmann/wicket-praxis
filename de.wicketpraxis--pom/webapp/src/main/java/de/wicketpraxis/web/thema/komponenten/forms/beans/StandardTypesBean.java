/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;
import java.util.Date;

public class StandardTypesBean implements Serializable {

	int _zahl;

	double _kommazahl;

	String _text;

	String _text2;

	Date _datum;

	public int getZahl() {
		return _zahl;
	}

	public void setZahl(int zahl) {
		_zahl = zahl;
	}

	public double getKommazahl() {
		return _kommazahl;
	}

	public void setKommazahl(double kommazahl) {
		_kommazahl = kommazahl;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getText2() {
		return _text2;
	}

	public void setText2(String text2) {
		_text2 = text2;
	}

	public Date getDatum() {
		return _datum;
	}

	public void setDatum(Date datum) {
		_datum = datum;
	}

}
