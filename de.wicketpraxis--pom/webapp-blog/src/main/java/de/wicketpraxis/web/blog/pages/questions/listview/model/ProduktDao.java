package de.wicketpraxis.web.blog.pages.questions.listview.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProduktDao implements Serializable
{
	static List<Produkt> _produkte=new ArrayList<Produkt>();
	static
	{
		for (int i=0;i<10;i++)
		{
			_produkte.add(new Produkt(i,"Produkt "+i,true));
		}
	}
	
	public List<Produkt> getProdukte()
	{
		List<Produkt> ret=new ArrayList<Produkt>();
		for (Produkt p : _produkte)
		{
			Produkt copy = new Produkt();
			copy.setValuesFrom(p);
			ret.add(copy);
		}
		return ret;
	}
	
	public Produkt getProduktById(int id)
	{
		for (Produkt p : _produkte)
		{
			if (p.getId()==id) return p;
		}
		return null;
	}
	
	public void update(Produkt p)
	{
		Produkt produkt = getProduktById(p.getId());
		if (produkt!=null) produkt.setValuesFrom(p);
	}
}
