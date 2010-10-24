/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.session.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ProtectedPage extends AbstractBasePage implements SecurePageInterface
{
	public ProtectedPage()
	{
		add(new BookmarkablePageLink<LogoutPage>("logout",LogoutPage.class));
		
		add(new SecureLabel("secureLabel",Model.of("Das darf nicht jeder sehen")));
		
		add(new SecureLink("secureLink")
		{
			@Override
			public void onClick()
			{
				
			}
		});
	}
	
	public static class SecureLabel extends Label implements SecureComponentInterface
	{
		public SecureLabel(String id, IModel<?> model)
		{
			super(id, model);
		}
	}
	
	public abstract static class SecureLink extends Link implements SecureComponentInterface
	{

		public SecureLink(String id)
		{
			super(id);
		}
		
	}
}
