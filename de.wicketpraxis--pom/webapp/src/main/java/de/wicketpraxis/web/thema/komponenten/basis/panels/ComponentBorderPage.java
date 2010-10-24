/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.Component;
import org.apache.wicket.IComponentBorder;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.MarkupComponentBorder;

public class ComponentBorderPage extends WebPage
{
	public ComponentBorderPage()
	{
		add(new Label("l1","in red border").setComponentBorder(new RedBorder()));
		add(new Label("l2","in blue border").setComponentBorder(new BlueBorder()));
	}
	
	static class RedBorder implements IComponentBorder
	{
		public void renderBefore(Component component)
		{
			component.getResponse().write("<div style=\"border:1px solid red;\">");
		}
		public void renderAfter(Component component)
		{
			component.getResponse().write("</div>");
		}
	}
	
	static class BlueBorder extends MarkupComponentBorder
	{
		
	}
}
