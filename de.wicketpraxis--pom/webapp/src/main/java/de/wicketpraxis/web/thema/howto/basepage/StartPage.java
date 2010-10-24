/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.basepage;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.howto.basepage.nav.AbstractNavCallback;
import de.wicketpraxis.web.thema.howto.basepage.nav.NavCallbackInterface;

@TitleAnnotation(title="Basisseite und Navigation")
public class StartPage extends AbstractBasePage
{
	IModel<Integer> _clicked=new Model<Integer>();
	
	public StartPage()
	{
		add(new Label("clicked",_clicked)
		{
			@Override
			protected void onBeforeRender()
			{
				super.onBeforeRender();
				setVisible(getDefaultModelObject()!=null ? true : false);
			}
			@Override
			protected boolean callOnBeforeRenderIfNotVisible()
			{
				return true;
			}
		});
	}
	
	@Override
	public List<NavCallbackInterface> getNavigations()
	{
		List<NavCallbackInterface> ret=new ArrayList<NavCallbackInterface>();
		ret.add(new AbstractNavCallback("Klick 1")
		{
			public void onClick(Page page)
			{
				_clicked.setObject(1);
			}
			
			@Override
			public boolean isActive(Page page)
			{
				Integer lastClick = _clicked.getObject();
				if (lastClick==null) return false;
				return lastClick.equals(1);
			}
		});
		ret.add(new AbstractNavCallback("Klick 2")
		{
			public void onClick(Page page)
			{
				_clicked.setObject(2);
			}
			
			@Override
			public boolean isActive(Page page)
			{
				Integer lastClick = _clicked.getObject();
				if (lastClick==null) return false;
				return lastClick.equals(2);
			}
		});
		return ret;
	}
}
