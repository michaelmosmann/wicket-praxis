/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;

public abstract class AbstractKapitel extends WebPage
{
	public AbstractKapitel()
	{
		add(new Label("title",getTitle()));
		
		List<Class<? extends Page>> pages=new ArrayList<Class<? extends Page>>();
		
		addPages(pages);
		
		final Map<Class<? extends Page>, String> classNameMap = Util.getClassNameMap(pages);
		
		ListView<Class<? extends Page>> listView = new ListView<Class<? extends Page>>("list",pages)
		{
			int _idx=0;
			
			@Override
			protected void populateItem(ListItem<Class<? extends Page>> item)
			{
				_idx++;
				
				Class<? extends Page> pageClass = item.getModelObject();
				if (Util.leaveSomeSpace(pageClass))
				{
					item.add(new AttributeModifier("style",true,Model.of("padding-top:10px;")));
				}
				item.add(new BookmarkablePageLink<Page>("link",pageClass).add(new Label("label",classNameMap.get(pageClass))));
			}
		};
		
		add(listView);
		List<Class<? extends Page>> parentPageList = getParentPageList();
		Collections.reverse(parentPageList);
		add(new ListView<Class<? extends Page>>("back",parentPageList)
		{
			@Override
			protected void populateItem(ListItem<Class<? extends Page>> item)
			{
				Class<? extends Page> pageClass = item.getModelObject();
				String backLinkTitle = Util.getTitle(pageClass);
				item.add(new BookmarkablePageLink<OverViewPage>("link",pageClass).add(new Label("name",backLinkTitle !=null ? backLinkTitle : "zurück")));
			}
		});
		
		add(new Label("titleCurrent",getTitle()));
		
//		String backLinkTitle = Util.getTitle(getParentPageClass());
//		add(new BookmarkablePageLink<OverViewPage>("back",getParentPageClass()).add(new Label("name",backLinkTitle !=null ? backLinkTitle : "zurück")));
		
	}
	
	private List<Class<? extends Page>> getParentPageList()
	{
		List<Class<? extends Page>> ret=new ArrayList<Class<? extends Page>>();
		
		Class<? extends Page> parentPageClass = getParentPageClass();
		while (parentPageClass!=null)
		{
			ret.add(parentPageClass);
			try
			{
				Page newInstance = parentPageClass.newInstance();
				if (newInstance instanceof AbstractKapitel)
				{
					AbstractKapitel k=(AbstractKapitel) newInstance;
					parentPageClass=k.getParentPageClass();
				}
				else parentPageClass=null;
			}
			catch (InstantiationException e)
			{
				parentPageClass=null;
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				parentPageClass=null;
				e.printStackTrace();
			}
		}
		return ret;
	}

	protected Class<? extends Page> getParentPageClass()
	{
		return OverViewPage.class;
	}
	
	protected String getTitle()
	{
		String title = Util.getTitle(this.getClass());
		return title!=null ? title : "keine Annotation";
	};
	
	protected abstract void addPages(List<Class<? extends Page>> pages);
}
