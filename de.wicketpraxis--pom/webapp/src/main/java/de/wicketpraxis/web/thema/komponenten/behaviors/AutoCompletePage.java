/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.DefaultCssAutocompleteTextField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class AutoCompletePage extends WebPage
{
	public AutoCompletePage()
	{
		add(new DefaultCssAutocompleteTextField<String>("input",Model.of(""))
		{
			@Override
			protected Iterator<String> getChoices(String input)
			{
				List<String> ret=new ArrayList<String>();
				if (input!=null)
				{
					if ("a".equals(input))
					{
						ret=Arrays.asList("auto","achim","alexandra");
					}
					if ("b".equals(input))
					{
						ret=Arrays.asList("bett","blub","badewanne");
					}
				}
				return ret.iterator();
			}
		});
	}
}
