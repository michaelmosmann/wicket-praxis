/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.behaviors;

import java.util.Date;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.time.Duration;

public class AjaxUpdatingPage extends WebPage
{
	public AjaxUpdatingPage()
	{
		LoadableDetachableModel<String> uhrModel=new LoadableDetachableModel<String>()
		{
			@Override
			protected String load()
			{
				return "Mit dem Zeitzeichen ist es genau "+new Date();
			}
		};
		
		Label uhr=new Label("uhr",uhrModel);
		uhr.setOutputMarkupId(true);
		uhr.add(new AjaxSelfUpdatingTimerBehavior(Duration.ONE_SECOND));
		add(uhr);
	}
}
