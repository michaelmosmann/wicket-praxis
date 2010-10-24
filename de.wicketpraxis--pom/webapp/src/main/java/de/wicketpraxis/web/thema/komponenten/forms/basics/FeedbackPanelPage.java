/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import de.wicketpraxis.web.thema.komponenten.forms.Forms;

public class FeedbackPanelPage extends WebPage
{
	public FeedbackPanelPage()
	{
		add(Forms.getCss());
		
		add(new FeedbackPanel("feedback"));
		
		add(new Link("link")
		{
			@Override
			public void onClick()
			{
				info("Geklickt");
			}
		});
		
		add(new Link("linkWarnung")
		{
			@Override
			public void onClick()
			{
				warn("Achtung");
			}
		});
		
		add(new Link("linkFehler")
		{
			@Override
			public void onClick()
			{
				error("Irren ist menschlich.");
			}
		});
	}
}
