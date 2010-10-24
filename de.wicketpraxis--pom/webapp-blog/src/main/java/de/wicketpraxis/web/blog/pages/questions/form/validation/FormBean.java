package de.wicketpraxis.web.blog.pages.questions.form.validation;

import java.io.Serializable;

public class FormBean implements Serializable
{
	Integer _a;
	
	Integer _b;

	public Integer getA()
	{
		return _a;
	}

	public void setA(Integer a)
	{
		_a = a;
	}

	public Integer getB()
	{
		return _b;
	}

	public void setB(Integer b)
	{
		_b = b;
	}
	
}
