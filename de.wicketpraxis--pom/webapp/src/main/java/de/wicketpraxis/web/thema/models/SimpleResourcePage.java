/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Simple Resource",space=true)
public class SimpleResourcePage extends WebPage
{
	public SimpleResourcePage()
	{
		add(new Label("text",getString("text", Model.of(12), "Nicht gefunden")));
	}
}
