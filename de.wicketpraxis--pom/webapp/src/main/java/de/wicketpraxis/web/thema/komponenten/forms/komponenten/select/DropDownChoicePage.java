/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.select;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.ListChoice;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.WochentagBean;

public class DropDownChoicePage extends AbstractFormPage
{
	static LinkedHashMap<Integer,String> _tage=new LinkedHashMap<Integer, String>();
	static
	{
		_tage.put(Calendar.MONDAY,"Montag");
		_tage.put(Calendar.TUESDAY,"Dienstag");
		_tage.put(Calendar.WEDNESDAY,"Mittwoch");
		_tage.put(Calendar.THURSDAY,"Donnerstag");
		_tage.put(Calendar.FRIDAY,"Freitag");
		_tage.put(Calendar.SATURDAY,"Sonnabend");
		_tage.put(Calendar.SUNDAY,"Sonntag");
	}
	
	public DropDownChoicePage()
	{
		Form<WochentagBean> form=new Form<WochentagBean>("form",new CompoundPropertyModel<WochentagBean>(new WochentagBean()))
		{
			@Override
			protected void onSubmit()
			{
				WochentagBean bean = getModelObject();
				info("Tag 1: "+bean.getTag1());
				info("Tag 2: "+bean.getTag2());
				info("Tag 3: "+bean.getTag3());
			}
		};
		
		IModel<List<? extends Integer>> choices = Model.of((List<Integer>) new ArrayList<Integer>(_tage.keySet()));
		IChoiceRenderer<Integer> renderer=new IChoiceRenderer<Integer>()
		{
			public Object getDisplayValue(Integer object)
			{
				return _tage.get(object);
			}
			public String getIdValue(Integer object, int index)
			{
				return object.toString();
			}
		};
		form.add(new DropDownChoice<Integer>("Tag1",choices,renderer));
		form.add(new DropDownChoice<Integer>("Tag2",choices,renderer));
//    ungeht validatoren und schreibt wert in Modell
//		{
//			@Override
//			protected boolean wantOnSelectionChangedNotifications()
//			{
//				return true;
//			}
//			
//			@Override
//			protected void onSelectionChanged(Integer newSelection)
//			{
//				info("New Selection: "+newSelection);
//			}
//		});
		
		form.add(new ListChoice<Integer>("Tag3",choices,renderer).setMaxRows(4));
		add(form);
	}
}
