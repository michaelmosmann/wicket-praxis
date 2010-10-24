/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.spring;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Spring Integration")
public class KapSpring extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimpleSpringIntegrationPage.class);
		pages.add(ExtendedSpringIntegrationPage.class);
	}

	@Override
	protected String getTitle()
	{
		return "Spring";
	}

}
