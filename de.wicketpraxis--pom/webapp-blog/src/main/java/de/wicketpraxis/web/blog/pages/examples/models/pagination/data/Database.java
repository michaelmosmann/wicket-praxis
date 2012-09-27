package de.wicketpraxis.web.blog.pages.examples.models.pagination.data;

import java.util.ArrayList;
import java.util.List;

import de.wicketpraxis.web.blog.pages.examples.models.pagination.IModelSource;
import de.wicketpraxis.web.blog.pages.examples.models.pagination.Range;

public class Database implements IModelSource<FromDatabase> {

	@Override
	public List<FromDatabase> get(Range<FromDatabase> range) {
		List<FromDatabase> ret = new ArrayList<FromDatabase>();
		for (long s = range.getStart(); s <= range.getEnd(); s++) {
			ret.add(new FromDatabase("Klaus", "Meier"));
		}
		return ret;
	}

	@Override
	public long max() {
		return 1000;
	}

}
