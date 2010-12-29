package de.wicketpraxis.web.blog.pages.questions.ajax.javascript;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.web.blog.model.CascadingLoadableDetachableModel;

public class WrapStringModel extends CascadingLoadableDetachableModel<String, String> {

	String _prefix;
	String _postfix;

	public WrapStringModel(String prefix, IModel<? extends String> parent, String postfix) {
		super(parent);
		_prefix = prefix;
		_postfix = postfix;
	}

	@Override
	protected String load(String p) {
		return _prefix + p + _postfix;
	}
}
