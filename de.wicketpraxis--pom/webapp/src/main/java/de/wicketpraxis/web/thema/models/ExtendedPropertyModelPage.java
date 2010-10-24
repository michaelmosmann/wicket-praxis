/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class ExtendedPropertyModelPage extends WebPage
{
	public ExtendedPropertyModelPage()
	{
		TestBean testBean=new TestBean();
		
		PropertyModel<String> simpleModel=new PropertyModel<String>(testBean,"name");
		simpleModel.setObject("Michael");
		add(new Label("simple",simpleModel));
		
		PropertyModel<String> arrayIndexModel=new PropertyModel<String>(testBean,"array.0");
		arrayIndexModel.setObject("Halli");
		add(new Label("array",arrayIndexModel));
		
		PropertyModel<String> array2IndexModel=new PropertyModel<String>(testBean,"array[1]");
		array2IndexModel.setObject("Hallo");
		add(new Label("array2",array2IndexModel));
		
		PropertyModel<Integer> listIndexModel=new PropertyModel<Integer>(testBean,"numbers[1]");
		listIndexModel.setObject(43);
		add(new Label("number",listIndexModel));
		
		// [] geht hier nicht
		PropertyModel<String> nameIndexModel=new PropertyModel<String>(testBean,"names.1");
		nameIndexModel.setObject("Susanne");
		add(new Label("name",nameIndexModel));
		
		
		// mit listIndexModel.setObject und ohne list2IndexModel.setObject gibt es einen Fehler
		// IndexOutOfBoundsException 
		PropertyModel<Integer> list2IndexModel=new PropertyModel<Integer>(testBean,"_numbers[2]");
		list2IndexModel.setObject(23);
		add(new Label("number2",list2IndexModel));
		
		PropertyModel<Color> mapIndexModel=new PropertyModel<Color>(testBean,"colorMap[red]");
		HashMap<String, Color> colorMap = new HashMap<String, Color>();
		colorMap.put("red", new Color(255,0,0));
		testBean.setColorMap(colorMap);
		add(new Label("map",mapIndexModel));
	}
	
	public static class TestBean
	{
		String _name;
		
		String[] _array=new String[2];
		
		// braucht Default Constructor 
		ArrayList<Integer> _numbers;
		
		// braucht Default Constructor 
		HashMap<String,Color> _colorMap;

		Map<Integer,String> _names=new HashMap<Integer, String>();
		
		public String getName()
		{
			return _name;
		}

		public void setName(String name)
		{
			_name = name;
		}

		public String[] getArray()
		{
			return _array;
		}

		public void setArray(String[] array)
		{
			_array = array;
		}

		public ArrayList<Integer> getNumbers()
		{
			return _numbers;
		}

		public void setNumbers(ArrayList<Integer> numbers)
		{
			_numbers = numbers;
		}

		public HashMap<String, Color> getColorMap()
		{
			return _colorMap;
		}

		public void setColorMap(HashMap<String, Color> colorMap)
		{
			_colorMap = colorMap;
		}
		
		
		public void setNames(int idx, String name)
		{
			System.out.println("SetNames: "+idx+" -> "+name);
			_names.put(idx, name);
		}
		
		public String getNames(int idx)
		{
			return _names.get(idx);
		}

//		public Map<Integer, String> getNames()
//		{
//			return _names;
//		}

//		public void setNames(Map<Integer, String> names)
//		{
//			_names = names;
//		}
		
	}
}
