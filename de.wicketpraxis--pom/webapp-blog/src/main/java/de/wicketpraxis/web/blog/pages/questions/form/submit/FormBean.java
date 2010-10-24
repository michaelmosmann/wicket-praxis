package de.wicketpraxis.web.blog.pages.questions.form.submit;

import java.io.Serializable;

public class FormBean implements Serializable
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
