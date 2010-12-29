/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Models")
public class KapModels extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(SimpleModelPage.class);
		pages.add(ModelChangePage.class);
		pages.add(SerializableModelPage.class);
		pages.add(ModelTypesPage.class);

		pages.add(DetachedModelPage.class);
		pages.add(DetachedDetachedModelPage.class);
		pages.add(CascadingDetachedModelPage.class);
		pages.add(CascadingDetachedModelModelPage.class);

		pages.add(SimpleDaoModelPage.class);

		pages.add(HandmadePropertyModelPage.class);
		pages.add(PropertyModelPage.class);
		pages.add(ExtendedPropertyModelPage.class);
		pages.add(CompoundPropertyModelPage.class);
		pages.add(DaoModelPage.class);

		pages.add(SimpleResourcePage.class);
		pages.add(ResourceModelPage.class);
		pages.add(StringResourceModelPage.class);

	}

}
