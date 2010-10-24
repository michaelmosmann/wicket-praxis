/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import java.io.Serializable;
import java.util.Date;

public class SubBean implements Serializable
{
	Date _datum;
	
	public void setDatum(Date datum)
	{
		_datum = datum;
	}
	
	public Date getDatum()
	{
		return _datum;
	}

	@Override
	public String toString()
	{
		return "Datum: " + _datum;
	}
}
