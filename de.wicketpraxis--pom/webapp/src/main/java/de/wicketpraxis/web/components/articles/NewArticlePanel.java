/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.components.articles;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.wicketpraxis.persistence.beans.Article;
import de.wicketpraxis.persistence.beans.User;
import de.wicketpraxis.persistence.dao.ArticleDao;

public class NewArticlePanel extends Panel
{
	@SpringBean(name=ArticleDao.BEAN_ID)
	ArticleDao _articleDao;

	Model<Article> _model;
	
	IModel<User> _userModel;
	
	public NewArticlePanel(String id,IModel<User> userModel)
	{
		super(id);
		
		_userModel=userModel;
		
		_model=Model.of(new Article());
		
		Form<Article> form=new Form<Article>("form",new CompoundPropertyModel<Article>(_model))
		{
			@Override
			protected void onSubmit()
			{
				Article thingy = _model.getObject();
				thingy.setUser(_userModel.getObject());
				_articleDao.save(thingy);
				
				_model.setObject(new Article());
			}
		};
		
		form.add(new TextField<String>("Title").setRequired(true));
		form.add(new TextArea<String>("Text").setRequired(true));
		form.add(new Button("submit"));
		
		add(form);
		
		add(new FeedbackPanel("feedback",new ContainerFeedbackMessageFilter(this)));
	}
	
	@Override
	protected void detachModel()
	{
		super.detachModel();
		_userModel.detach();
	}
}
