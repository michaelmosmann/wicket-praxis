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
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SimpleModelPage extends WebPage
{
	public SimpleModelPage()
	{
//		IModel<String> message=new Model<String>("Initialwert");
		IModel<String> message=Model.of("Initialwert");
		
		message.setObject("Jetzt ist "+new Date());
		
		add(new Label("message",message));
	}
}
