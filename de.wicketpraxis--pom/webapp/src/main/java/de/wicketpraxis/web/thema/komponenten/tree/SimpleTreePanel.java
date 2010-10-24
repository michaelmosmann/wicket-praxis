/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.tree;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;

public class SimpleTreePanel extends Panel
{
	public static final String LEFT="left";
	public static final String RIGHT="right";
	
	boolean _changeable=false;
	
	public SimpleTreePanel(String id)
	{
		super(id);
		
		add(new EmptyPanel(LEFT));
		add(new EmptyPanel(RIGHT));
	}
	
	public SimpleTreePanel(String id,boolean changeable)
	{
		this(id);
		_changeable=changeable;
	}
	
	public SimpleTreePanel setLeft(Component left)
	{
		if (left.getId().equals(LEFT)) replace(left);
		return this;
	}
	
	public SimpleTreePanel setRight(Component right)
	{
		if (right.getId().equals(RIGHT)) replace(right);
		return this;
	}
	
	public boolean isChangeable()
	{
		return _changeable;
	}
	
}
