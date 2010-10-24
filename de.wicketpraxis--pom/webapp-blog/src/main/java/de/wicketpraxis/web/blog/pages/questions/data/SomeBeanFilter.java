package de.wicketpraxis.web.blog.pages.questions.data;

import java.io.Serializable;

public class SomeBeanFilter implements Serializable
{
	String _name;
	String _vorname;
	
	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}
	
	public String getVorname()
	{
		return _vorname;
	}
	
	public void setVorname(String vorname)
	{
		_vorname = vorname;
	}
	
	public boolean match(SomeBean bean)
	{
		boolean ret=true;
		
		if (_name!=null)
		{
			if (!bean.getName().startsWith(_name)) ret=false;
		}
		if (_vorname!=null)
		{
			if (!bean.getVorname().startsWith(_vorname)) ret=false;
		}
		
		return ret;
	}
}
