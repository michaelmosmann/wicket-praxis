/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.components.layout;

import org.apache.wicket.markup.html.border.Border;

public class Line extends Border
{
	public Line(String id)
	{
		super(id);
		
		setRenderBodyOnly(true);
	}
}
