/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.pages.user;

import org.apache.wicket.markup.html.panel.Panel;

import de.wicketpraxis.web.components.login.UserHasLoginPanel;
import de.wicketpraxis.web.pages.AbstractBasePage;

public class AbstractUserBasePage extends AbstractBasePage
{
	@Override
	protected Panel getHeadPanel(String id)
	{
		return new HeadPanel(id);
	}
	
	public static class HeadPanel extends Panel
	{
		public HeadPanel(String id)
		{
			super(id);
			
			add(new UserHasLoginPanel("user"));
		}
	}
}
