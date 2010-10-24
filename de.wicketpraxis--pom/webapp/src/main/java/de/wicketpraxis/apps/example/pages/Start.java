/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.apps.example.WicketExampleApplication;
import de.wicketpraxis.apps.example.components.layout.Grid;
import de.wicketpraxis.apps.example.components.layout.GridWithSpace;
import de.wicketpraxis.apps.example.components.layout.Line;
import de.wicketpraxis.apps.example.components.navigation.AbstractNavigationCallback;
import de.wicketpraxis.apps.example.components.navigation.NavigationCallbackInterface;
import de.wicketpraxis.apps.example.components.navigation.PageNavigationCallback;
import de.wicketpraxis.apps.example.pages.start.AbstractStartNav;
import de.wicketpraxis.apps.example.pages.start.MainNav;
import de.wicketpraxis.web.model.Cascading2LoadableDetachableModel;


public class Start extends AbstractNavigationPage
{
	String _idNav;
	
	public Start()
	{
		Line line = new Line("line1");
		line.add(new Grid("left",4).setStart(true));
		line.add(new GridWithSpace("right",5,3,0).setEnd(true));
		add(line);
		
		add(new FeedbackPanel("feedback"));
	}
	
	@Override
	protected IModel<List<NavigationCallbackInterface>> getNavigation()
	{
		return new LoadableDetachableModel<List<NavigationCallbackInterface>>()
		{
			@Override
			protected List<NavigationCallbackInterface> load()
			{
				List<NavigationCallbackInterface> ret=WicketExampleApplication.get().getNavigation();
				PageNavigationCallback.replaceCallback(ret, Start.class, new MainNav());
				return ret;
			}

		};
	}
	
	public void clickFrom(AbstractStartNav nav)
	{
		_idNav=nav.getID();
		info("Auf Navigation mit der ID "+_idNav+" geklickt");
	}
	
	public boolean isActive(AbstractStartNav nav)
	{
		if (_idNav!=null)
		{
			return _idNav.equals(nav.getID());
		}
		return false;
	}
}
