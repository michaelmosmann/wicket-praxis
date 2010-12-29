package de.wicketpraxis.web.blog.pages.migration.model.mwst;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.LoadableDetachableModel;

public class ResultListModel extends LoadableDetachableModel<List<Result>> {

	@Override
	protected List<Result> load() {
		List<Result> ret = new ArrayList<Result>();
		ret.add(new Result("Popcorn", 3.15));
		ret.add(new Result("Eis", 2.80));
		ret.add(new Result("Eintritt", 5.50));
		return ret;
	}
}
