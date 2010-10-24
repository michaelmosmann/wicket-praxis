/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.metadata;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;

public class MetaDataPage extends WebPage
{
	static final MetaDataKey<String> KEY=new MetaDataKey<String>()
	{
		private static final long serialVersionUID = 1L;
	};
	
	public MetaDataPage()
	{
		Session session = Session.get();
		
		// MetaData geht eigentlich überall
		session.setMetaData(KEY, "Metadaten");
		String metaData = session.getMetaData(KEY);
		
		setMetaData(KEY, "Komponentendaten");
	}
	
}
