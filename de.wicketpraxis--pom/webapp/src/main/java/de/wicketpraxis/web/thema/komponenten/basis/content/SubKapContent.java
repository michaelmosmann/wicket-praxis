/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;

@TitleAnnotation(title="Content, Images, etc.")
public class SubKapContent extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(SimpleLabelPage.class);
		pages.add(ConverterWithLabelPage.class);
		pages.add(VelocityPanelPage.class);
		pages.add(XmlPage.class);
		pages.add(FeedPage.class);
		pages.add(JSONPage.class);
		pages.add(WicketMessageTagPage.class);
		pages.add(SimpleImagePage.class);
		pages.add(ImageAsEnumPage.class);
		pages.add(SimpleDynamicImages.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return SubKapBasiskomponenten.class;
	}

}
