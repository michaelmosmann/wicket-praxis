/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "List Views")
public class ListViewPage extends WebPage
{
	public ListViewPage()
	{
		add(new ListView<String>("list", Arrays.asList("Das", "ist", "eine", "Textliste"))
		{
			@Override
			protected void populateItem(ListItem<String> item)
			{
				String text = item.getModelObject();
				
				item.add(new Label("part1",text.substring(0, 1)));
				item.add(new Label("part2",text.substring(1)));
				
			}
		});
	}
}
