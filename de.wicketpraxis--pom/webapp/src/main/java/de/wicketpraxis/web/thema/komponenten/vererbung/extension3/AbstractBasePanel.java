/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension3;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AbstractBasePanel extends Panel
{
	public AbstractBasePanel(String id)
	{
		super(id);
		
		add(getMessage());
		add(getChild("child"));
	}
	
	protected abstract BasePanelLabel getMessage();
	
	protected abstract Panel getChild(String id);
}
