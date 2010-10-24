/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.RequestUtils;

public class FeedPage extends WebPage
{
	public FeedPage()
	{
		add(new Label("Title","Wicketpraxis Feed"));
		add(new Label("ID",UUID.randomUUID().toString()));
		add(new Label("Updated",Model.of(new Date())));
		
		List<Entry> list=new ArrayList<Entry>();
		{
			Entry e = new Entry();
			e.setTitle("erster Beitrag");
			e.setID(UUID.randomUUID().toString());
			e.setLink(RequestUtils.toAbsolutePath(urlFor(FeedPage.class, new PageParameters()).toString()));
			e.setUpdated(new Date());
			e.setSummary("Das ist <strong>ein kleines</strong> Beispiel");
			e.setContent("Das ist <strong>ein kleines</strong> Beispiel. Hier mit <i>mehr</i> Inhalt.");
			list.add(e);
		}
		
		add(new PropertyListView<Entry>("entries",list)
		{
			@Override
			protected void populateItem(ListItem<Entry> item)
			{
				item.add(new Label("Title"));
				item.add(new WebMarkupContainer("Link").add(new AttributeModifier("href",true,Model.of(item.getModelObject().getLink()))));
				item.add(new Label("ID"));
				item.add(new Label("Updated"));
				item.add(new Label("Summary"));
				item.add(new Label("Content"));
			}
		});
	}
	
	@Override
	public String getMarkupType()
	{
		return "xml";
	}
	
	static class Entry implements Serializable
	{
		String _title;
		String _link;
		String _iD;
		Date _updated;
		
		String _summary;
		String _content;
		
		public String getTitle()
		{
			return _title;
		}
		public void setTitle(String title)
		{
			_title = title;
		}
		public String getLink()
		{
			return _link;
		}
		public void setLink(String link)
		{
			_link = link;
		}
		public String getID()
		{
			return _iD;
		}
		public void setID(String id)
		{
			_iD = id;
		}
		public Date getUpdated()
		{
			return _updated;
		}
		public void setUpdated(Date updated)
		{
			_updated = updated;
		}
		public String getSummary()
		{
			return _summary;
		}
		public void setSummary(String summary)
		{
			_summary = summary;
		}
		public String getContent()
		{
			return _content;
		}
		public void setContent(String content)
		{
			_content = content;
		}
		
		
	}
}
