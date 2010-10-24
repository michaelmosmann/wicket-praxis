/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension;

import org.apache.wicket.markup.html.basic.Label;

public class ExtendedWithMarkupPanel extends BasePanel
{
	public ExtendedWithMarkupPanel(String id)
	{
		super(id);
		
		// not the same id
		add(new Label("message2","Extends With Markup"));
	}
	
}
