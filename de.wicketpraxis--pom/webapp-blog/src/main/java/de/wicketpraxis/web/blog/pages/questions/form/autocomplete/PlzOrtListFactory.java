/**
 * 
 */
package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlzOrtListFactory implements Serializable {

	List<PlzOrt> _all = new ArrayList<PlzOrt>();

	{
		_all.add(new PlzOrt("23562", "Lübeck"));
		_all.add(new PlzOrt("23858", "Reinfeld"));
		_all.add(new PlzOrt("14199", "Berlin"));
		_all.add(new PlzOrt("70619", "Stuttgart"));

	}

	public PlzOrtListFactory() {
	}

	public List<PlzOrt> getList(String plz) {
		List<PlzOrt> ret = null;
		if ((plz != null) && (plz.length() > 0)) {
			ret = new ArrayList<PlzOrt>();
			for (PlzOrt po : _all) {
				if (po.getPlz().startsWith(plz))
					ret.add(po);
			}
		}
		return ret;
	}
}
