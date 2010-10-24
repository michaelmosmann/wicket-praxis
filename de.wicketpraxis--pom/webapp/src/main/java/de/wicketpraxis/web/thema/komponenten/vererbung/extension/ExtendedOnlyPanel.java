/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension;

public class ExtendedOnlyPanel extends BasePanel
{
	public ExtendedOnlyPanel(String id)
	{
		super(id);
	}
	
	@Override
	protected String getMessage()
	{
		return "Extends ("+super.getMessage()+")";
	}
}
