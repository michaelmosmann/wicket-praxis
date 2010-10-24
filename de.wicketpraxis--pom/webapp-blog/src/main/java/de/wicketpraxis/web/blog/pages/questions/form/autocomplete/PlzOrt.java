package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import java.io.Serializable;

public class PlzOrt implements Serializable
{
	String _plz;
	
	String _ort;
	
	public PlzOrt(String plz, String ort)
	{
		_plz=plz;
		_ort=ort;
	}
	
	public String getPlz()
	{
		return _plz;
	}
	
	public String getOrt()
	{
		return _ort;
	}
}
