package de.wicketpraxis.web.blog.pages.examples.models.pagination;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.blog.pages.examples.models.pagination.data.Database;
import de.wicketpraxis.web.blog.pages.examples.models.pagination.data.FromDatabase;


public class ModelPaginationPage extends WebPage {

	
	public ModelPaginationPage() {
		IModelSource<FromDatabase> db=new Database();
		
	}
}
