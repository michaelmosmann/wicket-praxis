/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IComponentInheritedModel;

public class CompoundPropertyModelPage extends WebPage
{
	public CompoundPropertyModelPage()
	{
		DummyBean bean=new DummyBean();
		bean.setSub(new SubBean());
		bean.setName("Achim");
		bean.getSub().setDatum(new Date());
		
		CompoundPropertyModel<DummyBean> model=new CompoundPropertyModel<DummyBean>(bean);
		
//		IComponentInheritedModel<DummyBean> canWrapModel=model;
//		AttachedCompoundPropertyModel
		
		setDefaultModel(model);
		
		add(new Label("name"));
		add(new Label("sub.datum"));
		add(new Label("toString",bean.toString()));
		
	}
}
