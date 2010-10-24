/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.req;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class NotStoreablePage extends WebPage
{
	Model<Integer> _counter = Model.of(0);
	
//	NotStoreDummyBean _bean=new NotStoreDummyBean();
	
	public NotStoreablePage()
	{
		add(new Label("counter",_counter));
		
		add(new Link<Integer>("link",_counter)
		{
			@Override
			public void onClick()
			{
			NotStoreablePage.this.modelChanging();
//			Integer count = _counter.getObject();
//			if (count!=null) count=count+1;
//			_counter.setObject(count);
			NotStoreablePage.this.modelChanged();
				
				Integer count=getModelObject();
				if (count!=null) count=count+1;
				setModelObject(count);
			}
		});
	}
	
	static class NotStoreDummyBean
	{
		String _name;
		
		public String getName()
		{
			return _name;
		}
		
		public void setName(String name)
		{
			_name = name;
		}
	}
}
