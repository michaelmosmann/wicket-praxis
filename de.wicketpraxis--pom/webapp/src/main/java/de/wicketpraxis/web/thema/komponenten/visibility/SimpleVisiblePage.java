/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.visibility;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class SimpleVisiblePage extends WebPage
{
	public SimpleVisiblePage()
	{
		add(new Label("view","Hallo"));
		add(new Label("hide","unsichtbar").setVisible(false));
		
		add(new Label("hidden","Auch unsichtbar")
		{
			@Override
			public boolean isVisible()
			{
				return false;
			}
		});
		
		add(new Label("invisible","Trotzdem unsichtbar")
		{
			@Override
			public boolean isVisible()
			{
				return true;
			}
			
			/*
			@Override
			protected void onBeforeRender()
			{
				super.onBeforeRender();
			}
			
			@Override
			protected boolean callOnBeforeRenderIfNotVisible()
			{
				return true;
			}
			*/
		
		}.setVisibilityAllowed(false));
	}
	
}
