package de.wicketpraxis.web.blog.pages.examples.models.pagination.data;

public class FromDatabase {

	final String _vorname;
	final String _name;

	public FromDatabase(String vorname, String name) {
		_vorname = vorname;
		_name = name;
	}

	public String getVorname() {
		return _vorname;
	}

	public String getName() {
		return _name;
	}
}
