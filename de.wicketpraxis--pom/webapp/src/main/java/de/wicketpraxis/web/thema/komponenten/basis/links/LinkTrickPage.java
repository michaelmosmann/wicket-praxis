/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class LinkTrickPage extends WebPage
{
	public LinkTrickPage()
	{
		Model<String> messageModel = Model.of("");
		add(new Label("message",messageModel));
		
		add(new Link<String>("link",messageModel)
		{
			@Override
			public void onClick()
			{
				setModelObject("Geklickt");
			}
		});
		
		add(new Link<String>("span",messageModel)
		{
			@Override
			public void onClick()
			{
				setModelObject("Trotzdem geklickt");
			}
		});
	}
}
