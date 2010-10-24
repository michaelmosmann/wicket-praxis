/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

public class SimpleFragmentPage extends WebPage
{
	public SimpleFragmentPage()
	{
		// Verkettung vieler Aufrufe möglich
		add(new Fragment("p1","fragment1",this).add(new Label("message","p1")));
		add(new Fragment("p2","fragment2",this).add(new Label("message","p2")));
		add(new Fragment("p3","fragment1",this).add(new Label("message","p3")));
	}
}
