/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.ResourceModel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Resource Model")
public class ResourceModelPage extends WebPage
{
	public ResourceModelPage()
	{
		add(new Label("text1",new ResourceModel("text1")));
//	add(new Label("text2",new ResourceModel("text2")));
		add(new Label("text2",new ResourceModel("text2","Nicht gefunden")));
		add(new Label("text3",new ResourceModel("text3")));
	}
}
