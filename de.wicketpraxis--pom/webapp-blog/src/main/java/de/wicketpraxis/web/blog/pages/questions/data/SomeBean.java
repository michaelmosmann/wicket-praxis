package de.wicketpraxis.web.blog.pages.questions.data;

import java.io.Serializable;

public class SomeBean implements Serializable {

	String _vorname;

	String _name;

	int _alter;

	public SomeBean(String vorname, String name, int alter) {
		_vorname = vorname;
		_name = name;
		_alter = alter;
	}

	public String getVorname() {
		return _vorname;
	}

	public String getName() {
		return _name;
	}

	public int getAlter() {
		return _alter;
	}

}
