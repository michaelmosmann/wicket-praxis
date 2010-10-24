package de.wicketpraxis.web.blog.pages.migration.model.mwst;

public class Result
{
	String _name;
	
	Double _betrag;
	
	public Result(String name, double betrag)
	{
		_name=name;
		_betrag=betrag;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public Double getBetrag()
	{
		return _betrag;
	}
}
