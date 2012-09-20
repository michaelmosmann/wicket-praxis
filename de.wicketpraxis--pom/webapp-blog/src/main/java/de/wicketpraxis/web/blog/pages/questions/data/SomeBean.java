package de.wicketpraxis.web.blog.pages.questions.data;

import java.io.Serializable;

public class SomeBean implements Serializable {

	String _vorname;

	String _name;

	int _alter;

	public SomeBean() {
	}

	public SomeBean(String vorname, String name, int alter) {
		_vorname = vorname;
		_name = name;
		_alter = alter;
	}

	public String getVorname() {
		return _vorname;
	}

	public void setVorname(String vorname) {
		_vorname = vorname;
	}

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

	public boolean match(SomeBean bean) {
		boolean ret = true;

		if (_name != null) {
			if (!bean.getName().startsWith(_name))
				ret = false;
		}
		if (_vorname != null) {
			if (!bean.getVorname().startsWith(_vorname))
				ret = false;
		}

		return ret;
	}

}
