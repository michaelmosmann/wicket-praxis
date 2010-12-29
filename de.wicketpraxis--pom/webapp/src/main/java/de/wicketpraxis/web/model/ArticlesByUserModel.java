/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.model;

import java.util.List;

import org.apache.wicket.model.IModel;

import de.wicketpraxis.persistence.beans.Article;
import de.wicketpraxis.persistence.dao.ArticleDao.ByUser;

public class ArticlesByUserModel extends Cascading3LoadableDetachableModel<List<Article>, ByUser, Integer, Integer> {

	public ArticlesByUserModel(IModel<? extends ByUser> userModel, IModel<? extends Integer> offset,
			IModel<? extends Integer> max) {
		super(userModel, offset, max);
	}

	@Override
	protected List<Article> load(ByUser p1, Integer p2, Integer p3) {
		return p1.getList(p2, p3);
	}
}
