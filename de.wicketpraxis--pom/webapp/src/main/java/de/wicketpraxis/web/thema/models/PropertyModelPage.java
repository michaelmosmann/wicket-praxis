/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Property Model")
public class PropertyModelPage extends WebPage
{
	public PropertyModelPage()
	{
		DummyBean bean=new DummyBean();
//		bean.setSub(new SubBean());
		
		PropertyModel<String> nameModel=new PropertyModel<String>(bean,"name");
		PropertyModel<Integer> alterModel=new PropertyModel<Integer>(bean,"alter");
		PropertyModel<Date> datumModel=new PropertyModel<Date>(bean,"sub.datum");
		
		nameModel.setObject("Klaus");
		alterModel.setObject(28);
		
		// SubBean wird erzeugt
		datumModel.setObject(new Date());
		
		add(new Label("name",nameModel));
		add(new Label("alter",alterModel));
		add(new Label("datum",datumModel));
		add(new Label("toString",bean.toString()));
	}
	
}
