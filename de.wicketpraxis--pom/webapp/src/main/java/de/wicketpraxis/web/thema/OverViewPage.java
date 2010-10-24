/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.wicketpraxis.web.pages.OrgStart;
import de.wicketpraxis.web.pages.Start;
import de.wicketpraxis.web.thema.debug.KapDebugging;
import de.wicketpraxis.web.thema.howto.KapHowto;
import de.wicketpraxis.web.thema.komponenten.KapKomponenten;
import de.wicketpraxis.web.thema.metadata.KapMetaData;
import de.wicketpraxis.web.thema.models.KapModels;
import de.wicketpraxis.web.thema.req.KapRequest;
import de.wicketpraxis.web.thema.sessions.KapSession;
import de.wicketpraxis.web.thema.spring.KapSpring;

@TitleAnnotation(title="Übersicht")
public class OverViewPage extends WebPage
{
	public OverViewPage()
	{
		List<Class<? extends AbstractKapitel>> pages=new ArrayList<Class<? extends AbstractKapitel>>();
		
		add(new BookmarkablePageLink<OrgStart>("start",OrgStart.class));
		
		pages.add(KapRequest.class);
		pages.add(KapModels.class);
		pages.add(KapKomponenten.class);
		pages.add(KapSpring.class);
		pages.add(KapSession.class);
		pages.add(KapMetaData.class);
		pages.add(KapHowto.class);
		pages.add(KapDebugging.class);
		
		final Map<Class<? extends AbstractKapitel>, String> classNameMap = Util.getClassNameMap(pages);
		
		ListView<Class<? extends AbstractKapitel>> listView = new ListView<Class<? extends AbstractKapitel>>("list",pages)
		{
			int _idx=0;
			
			@Override
			protected void populateItem(ListItem<Class<? extends AbstractKapitel>> item)
			{
				_idx++;
				Class<? extends AbstractKapitel> pageClass = item.getModelObject();
				item.add(new BookmarkablePageLink<Page>("link",pageClass).add(new Label("label",""+_idx+". "+classNameMap.get(pageClass))));
			}
		};
		
		add(listView);
	}
}
