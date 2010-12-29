/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.basis.SubKapBasiskomponenten;

@TitleAnnotation(title = "Repeater, Listen etc.")
public class SubKapRepeater extends AbstractKapitel {

	@Override
	protected void addPages(List<Class<? extends Page>> pages) {
		pages.add(RepeatingViewPage.class);
		pages.add(RefreshingViewPage.class);
		pages.add(ListViewPage.class);
		pages.add(PropertyListViewPage.class);
		pages.add(ColumnListViewPage.class);

		pages.add(DataViewPage.class);
		pages.add(GridViewPage.class);
		pages.add(DataGridViewPage.class);
		pages.add(DataTablePage.class);
		pages.add(DefaultDataTablePage.class);
		pages.add(FilterDataTablePage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass() {
		return SubKapBasiskomponenten.class;
	}

}
