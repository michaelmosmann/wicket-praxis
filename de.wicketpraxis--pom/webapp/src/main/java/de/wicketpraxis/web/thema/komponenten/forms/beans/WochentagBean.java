/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;

public class WochentagBean implements Serializable {

	int _tag1;
	Integer _tag2;
	Integer _tag3;

	public int getTag1() {
		return _tag1;
	}

	public void setTag1(int tag1) {
		_tag1 = tag1;
	}

	public Integer getTag2() {
		return _tag2;
	}

	public void setTag2(Integer tag2) {
		_tag2 = tag2;
	}

	public Integer getTag3() {
		return _tag3;
	}

	public void setTag3(Integer tag3) {
		_tag3 = tag3;
	}

}
