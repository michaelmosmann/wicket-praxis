/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.components.layout;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class GridWithSpace extends Grid
{
	int _spaceBefore;
	int _spaceAfter;
	
	public GridWithSpace(String id, int columns, int spaceBefore, int spaceAfter)
	{
		super(id, columns);
		
		_spaceBefore=spaceBefore;
		_spaceAfter=spaceAfter;

		IModel<String> prefixModel=new LoadableDetachableModel<String>()
		{
			@Override
			protected String load()
			{
				return _spaceBefore!=0 ? "prefix_"+_spaceBefore : null;
			}
		};
		
		add(new AttributeAppender("class",true,prefixModel," "));
		
		IModel<String> postfixModel=new LoadableDetachableModel<String>()
		{
			@Override
			protected String load()
			{
				return _spaceAfter!=0 ? "sufix_"+_spaceAfter : null;
			}
		};
		
		add(new AttributeAppender("class",true,postfixModel," "));
	}
}
