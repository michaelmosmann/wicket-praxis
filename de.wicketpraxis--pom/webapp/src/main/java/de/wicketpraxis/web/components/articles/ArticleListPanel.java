/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.components.articles;

import java.util.Date;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.Article;
import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.ArticleDao;
import de.wicketpraxis.web.components.paging.OffsetPagePanel;
import de.wicketpraxis.web.model.ArticleSizeByUserModel;
import de.wicketpraxis.web.model.ArticlesByUserModel;
import de.wicketpraxis.web.model.ByUserFromUserModel;

public class ArticleListPanel extends Panel {

	@SpringBean(name = ArticleDao.BEAN_ID)
	ArticleDao _articleDao;

	// @SpringBean(name=UserDaoInterface.BEAN_ID)
	// UserDaoInterface _userDao;
	//	
	public ArticleListPanel(String id, IModel<User> userModel) {
		super(id);

		setOutputMarkupId(true);

		Model<Integer> offset = Model.of(0);
		Model<Integer> max = Model.of(5);

		// UserIdFromSessionModel userIdFromSession=new UserIdFromSessionModel();
		//		
		// UserFromIdModel userFromId=new
		// UserFromIdModel(_userDao,userIdFromSession);
		ByUserFromUserModel byUserModel = new ByUserFromUserModel(_articleDao, userModel);

		ArticlesByUserModel articles = new ArticlesByUserModel(byUserModel, offset, max);

		ArticleSizeByUserModel articleSize = new ArticleSizeByUserModel(byUserModel);

		add(new OffsetPagePanel("pages", offset, max, articleSize));

		ListView<Article> listView = new ListView<Article>("list", articles) {

			@Override
			protected void populateItem(ListItem<Article> item) {
				Article article = item.getModelObject();
				String stitle = article.getTitle();
				item.add(new Label("title", stitle));
				Article thingy = item.getModelObject();
				item.add(new Label("created", Model.of(thingy.getCreated())));
				item.add(new AjaxFallbackLink<Integer>("delete", Model.of(thingy.getId())) {

					@Override
					public void onClick(AjaxRequestTarget target) {
						Article toDelete = _articleDao.get(getModelObject());
						if (toDelete != null) {
							_articleDao.delete(toDelete);
							info("Article " + getModelObject() + " deleted");
						}

						if (target != null) {
							target.add(ArticleListPanel.this);
						}
					}
				});

				String style = "black";

				if (stitle.startsWith("r"))
					style = "red";
				if (stitle.startsWith("g"))
					style = "green";
				if (stitle.startsWith("b"))
					style = "blue";

				item.add(new AttributeModifier("style", true, Model.of("color: " + style)));

			}
		};

		add(listView);
	}
}
