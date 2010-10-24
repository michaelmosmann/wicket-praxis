/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;
import java.text.MessageFormat;

public class CalcBean implements Serializable
{
	int _a;
	
	int _b;
	
	int _summe;

	public int getA()
	{
		return _a;
	}

	public void setA(int a)
	{
		_a = a;
	}

	public int getB()
	{
		return _b;
	}

	public void setB(int b)
	{
		_b = b;
	}

	public int getSumme()
	{
		return _summe;
	}

	public void setSumme(int summe)
	{
		_summe = summe;
	}
	
	public String toString()
	{
		return MessageFormat.format("A: {0}, B: {1}, Summe: {2}", _a,_b,_summe);
	}
	
}
