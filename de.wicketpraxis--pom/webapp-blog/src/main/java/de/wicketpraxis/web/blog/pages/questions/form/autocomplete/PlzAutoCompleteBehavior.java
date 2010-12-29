/**
 * 
 */
package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteBehavior;
import org.apache.wicket.markup.html.form.FormComponent;

class PlzAutoCompleteBehavior extends AutoCompleteBehavior<PlzOrt> {

	PlzOrtListFactory _listFactory;

	public PlzAutoCompleteBehavior(PlzOrtListFactory listFactory, FormComponent<?> ortInput) {
		super(new PlzOrtRenderer(ortInput));

		_listFactory = listFactory;
	}

	@Override
	protected Iterator<PlzOrt> getChoices(String input) {
		List<PlzOrt> list = _listFactory.getList(input);
		if (list != null)
			return list.iterator();
		return Collections.EMPTY_LIST.iterator();
	}
}
