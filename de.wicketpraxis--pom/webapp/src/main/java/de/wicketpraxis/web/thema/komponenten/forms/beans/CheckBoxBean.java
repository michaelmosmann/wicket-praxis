/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class CheckBoxBean implements Serializable
{
	boolean _check;
	
	ArrayList<String> _liste=new ArrayList<String>();

	public boolean isCheck()
	{
		return _check;
	}

	public void setCheck(boolean check)
	{
		_check = check;
	}

	public ArrayList<String> getListe()
	{
		return _liste;
	}

	public void setListe(ArrayList<String> liste)
	{
		_liste = liste;
	}

	
}
