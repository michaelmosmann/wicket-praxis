/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.basics;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;

@TitleAnnotation(title="Formulare - Basics")
public class SubKapBasics extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(FeedbackPanelPage.class);
		pages.add(StandardFormPage.class);
		pages.add(FormSubmitButtonsPage.class);
		pages.add(FormAjaxSubmitButtonsPage.class);
		pages.add(FormMethodPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return SubKapForms.class;
	}

}
