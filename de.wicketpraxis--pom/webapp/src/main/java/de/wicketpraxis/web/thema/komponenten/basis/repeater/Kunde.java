/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.io.Serializable;

public class Kunde implements Serializable
{
	String _name;
	String _vorname;
	int _geburtsjahr;
	
	public Kunde(String vorname, String name,int geburtsjahr)
	{
		super();
		_vorname = vorname;
		_name = name;
		_geburtsjahr=geburtsjahr;
	}
	
	public String getVorname()
	{
		return _vorname;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public int getGeburtsjahr()
	{
		return _geburtsjahr;
	}
	
}
