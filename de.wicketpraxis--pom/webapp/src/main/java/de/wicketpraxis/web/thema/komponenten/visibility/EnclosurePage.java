/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.visibility;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class EnclosurePage extends WebPage
{
	public EnclosurePage()
	{
		add(new Label("view","Hallo"));
		add(new Label("hide","unsichtbar").setVisible(false));
		add(new Label("view2","Das zweite Mal"));
		add(new Label("hide2","wieder unsichtbar").setVisible(false));
		
//		add(new Link("link")
//		{
//			@Override
//			public void onClick()
//			{
//				EnclosurePage.this.visitChildren(new IVisitor<Component>()
//						{
//							public Object component(Component component)
//							{
//								if (component instanceof Label)
//								{
//									component.setVisible(true);
//								}
//								return IVisitor.CONTINUE_TRAVERSAL;
//							};
//						});
//				
//			}
//		});
	}
}
