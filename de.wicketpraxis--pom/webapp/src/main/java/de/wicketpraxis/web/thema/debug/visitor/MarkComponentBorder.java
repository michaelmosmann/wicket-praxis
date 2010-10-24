/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.debug.visitor;

import org.apache.wicket.Component;
import org.apache.wicket.IComponentBorder;

public class MarkComponentBorder implements IComponentBorder
{
	public void renderBefore(Component component)
	{
		component.getResponse().write("[--");
	}
	public void renderAfter(Component component)
	{
		component.getResponse().write("--]");
	}
}
