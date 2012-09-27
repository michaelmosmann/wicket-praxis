package de.wicketpraxis.web.blog.pages.examples.models.pagination.data;

public class ViewOnly {

	final long _index;
	final String _short;

	public ViewOnly(long index,FromDatabase source) {
		_index = index;
		_short = "" + source.getVorname().charAt(0) + ". " + source.getName();
	}

	public long getIndex() {
		return _index;
	}

	public String getShort() {
		return _short;
	}
}
