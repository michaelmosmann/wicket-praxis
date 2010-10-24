/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.vererbung.extension3;

import org.apache.wicket.markup.html.panel.Panel;

// war vorher HalloPanel
public class HasBoxPanel extends AbstractBasePanel
{
	public HasBoxPanel(String id)
	{
		super(id);
	}

	@Override
	protected Panel getChild(String id)
	{
		return new BoxPanel(id);
	}

	@Override
	protected BasePanelLabel getMessage()
	{
		return new HasBoxLabel();
	}

	static class HasBoxLabel extends BasePanelLabel
	{
		public HasBoxLabel()
		{
			super("Hab ne Box");
		}
	}
}
