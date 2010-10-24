/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.css;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.wicketpraxis.apps.example.components.layout.Grid;
import de.wicketpraxis.apps.example.components.layout.GridWithSpace;
import de.wicketpraxis.apps.example.components.layout.Line;
import de.wicketpraxis.web.thema.howto.css.styles.Style;

public class BasePageWithCSS extends WebPage
{
	public BasePageWithCSS()
	{
		List<IHeaderContributor> cssList = Style.getCss();
		for (IHeaderContributor css : cssList)
		{
			add(new HeaderContributor(css));
		}
		
		add(new ListView<Integer>("list",Arrays.asList(1,2,3,4))
		{
			@Override
			protected void populateItem(ListItem<Integer> item)
			{
				Integer index = item.getModelObject();
				
				Line line = new Line("start");
				line.add(new Grid("left",4+index));
				line.add(new GridWithSpace("right",4+index,8-(index*2),0));
				item.add(line);				
			}
		});

	}
}
