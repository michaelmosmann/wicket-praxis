/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;

public class SimpleBorderPage extends WebPage
{
	public SimpleBorderPage()
	{
		RedBorder redBorder = new RedBorder("red");
		redBorder.add(new Label("message","in red border"));
		add(redBorder);
		BlueBorder blueBorder = new BlueBorder("blue");
		blueBorder.add(new Label("message","in blue border"));
		add(blueBorder);
	}
	
	static class RedBorder extends Border
	{
		public RedBorder(String id)
		{
			super(id);
		}
	}
	
	static class BlueBorder extends Border
	{
		public BlueBorder(String id)
		{
			super(id);
		}
	}
}
