/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.seolinks;

import java.io.Serializable;

public class ConfigBean implements Serializable
{
	Integer _seite;
	String _kategorie;
	
	@PublicProperty
	public Integer getSeite()
	{
		return _seite;
	}
	public void setSeite(Integer seite)
	{
		_seite = seite;
	}
	
	@PublicProperty
	public String getKategorie()
	{
		return _kategorie;
	}
	public void setKategorie(String kategorie)
	{
		_kategorie = kategorie;
	}
	
	public ConfigBean getClone()
	{
		ConfigBean ret=new ConfigBean();
		ret._kategorie=_kategorie;
		ret._seite=_seite;
		return ret;
	}
}
