/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.links;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.ResourceLink;

public class ResourceLinksPage extends WebPage
{
	public ResourceLinksPage() throws URISyntaxException
	{
		// nicht relativ zur Seite
		add(new ResourceLink("appResource",new ResourceReference("images/test.gif")));
		add(new ResourceLink("resource",new ResourceReference(ResourceLinksPage.class,"images/test.gif")));
		
		URL resourceURI = getClass().getResource("/"+getClass().getPackage().getName().replace('.', File.separatorChar)+"/images/test.gif");
		System.out.println("File: "+resourceURI);
		add(new DownloadLink("file",new File(resourceURI.toURI()),"test.gif"));
	}
}
