package de.wicketpraxis.web.blog.pages.migration.refactor.step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class CalendarPanel extends Panel
{
	final static List<Integer> ALL_DAYS=Collections.unmodifiableList(Arrays.asList(Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SUNDAY, Calendar.SATURDAY));
	
	public CalendarPanel(String id, Date date)
	{
		super(id);
		
		Calendar cal = Calendar.getInstance(getLocale());
		cal.setTime(date);
		int daysInMonth=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		int dayOfWeekStart=cal.get(Calendar.DAY_OF_WEEK);
		int weeks=(dayOfWeekStart+daysInMonth+6)/7;
		List<Integer> weekList=new ArrayList<Integer>();
		for (int i=0;i<weeks;i++) weekList.add(i);
		
		add(new Label("daysInMonth",Model.of(daysInMonth)));
		add(new Label("dayOfWeekStart",Model.of(dayOfWeekStart)));
		
		add(new ListView<Integer>("week",weekList)
		{
			@Override
			protected void populateItem(ListItem<Integer> item)
			{
			}
		});
		
		add(new ListView<Integer>("weekDays",ALL_DAYS)
		{
			@Override
			protected void populateItem(ListItem<Integer> item)
			{
				
			}
		});
	}

}
