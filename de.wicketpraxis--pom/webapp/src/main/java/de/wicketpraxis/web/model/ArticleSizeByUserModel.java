/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.model;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.persistence.dao.ArticleDao.ByUser;

public class ArticleSizeByUserModel extends CascadingLoadableDetachableModel<Integer, ByUser> {

	private static final Logger _logger = LoggerFactory.getLogger(ArticleSizeByUserModel.class);

	public ArticleSizeByUserModel(IModel<? extends ByUser> parent) {
		super(parent);
	}

	@Override
	protected Integer load(ByUser parentModelData) {
		return parentModelData.getSize();
	}
}
