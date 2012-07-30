/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.blog.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import de.wicketpraxis.web.blog.pages.migration.ajax.AjaxMultiUpdatePage;
import de.wicketpraxis.web.blog.pages.migration.model.mwst.SomeModelsPage;
import de.wicketpraxis.web.blog.pages.migration.model.property.UseOrNotUsePropertyModelPage;
import de.wicketpraxis.web.blog.pages.migration.model.transformation.TransformationPage;
import de.wicketpraxis.web.blog.pages.migration.refactor.CalendarRefactorPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.behavior.AjaxRegionPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.javascript.JavascriptAjaxHeadContributorPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.modal.ModalWindowPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.overview.AjaxJavascriptOverviewPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.parameter.HeatMapPage;
import de.wicketpraxis.web.blog.pages.questions.ajax.parameter.ParameterizedAjaxPage;
import de.wicketpraxis.web.blog.pages.questions.backbutton.BackButtonStartPage;
import de.wicketpraxis.web.blog.pages.questions.checkgroup.fromdb.CheckGroupFromDbPage;
import de.wicketpraxis.web.blog.pages.questions.datatable.DataTablePage;
import de.wicketpraxis.web.blog.pages.questions.dataview.DataViewPage;
import de.wicketpraxis.web.blog.pages.questions.email.EmailFromComponentPage;
import de.wicketpraxis.web.blog.pages.questions.events.EventPage;
import de.wicketpraxis.web.blog.pages.questions.factories.ComponentFactoryPage;
import de.wicketpraxis.web.blog.pages.questions.form.autocomplete.FormAutoCompletePage;
import de.wicketpraxis.web.blog.pages.questions.form.submit.FormSubmitPage;
import de.wicketpraxis.web.blog.pages.questions.form.validation.FormValidationPage;
import de.wicketpraxis.web.blog.pages.questions.lazy.LazyPanelPage;
import de.wicketpraxis.web.blog.pages.questions.listview.ajax.ListViewAjaxRefreshPage;
import de.wicketpraxis.web.blog.pages.questions.listview.model.ListViewModelChangePage;
import de.wicketpraxis.web.blog.pages.questions.mergedresources.MergedResourcePage;
import de.wicketpraxis.web.blog.pages.questions.migration.forms.KomplexFormPage;
import de.wicketpraxis.web.blog.pages.questions.migration.forms.MinimalFormPage;
import de.wicketpraxis.web.blog.pages.questions.seo.ajax.SeoAjaxLinksPage;
import de.wicketpraxis.web.blog.pages.questions.seo.requests.FirstRequestPage;
import de.wicketpraxis.web.blog.pages.questions.transparent.TransparentResolverPage;
import de.wicketpraxis.web.blog.pages.questions.transparent.lazy.NoTransparentResolverPage;

public class Start extends WebPage {

	public Start() {
		List<Class<? extends WebPage>> pages = new ArrayList<Class<? extends WebPage>>();
		pages.add(CheckGroupFromDbPage.class);
		pages.add(ListViewAjaxRefreshPage.class);
		pages.add(MinimalFormPage.class);
		pages.add(KomplexFormPage.class);
		pages.add(AjaxMultiUpdatePage.class);
		pages.add(SomeModelsPage.class);
		pages.add(DataTablePage.class);
		pages.add(DataViewPage.class);
		pages.add(CalendarRefactorPage.class);
		pages.add(ListViewModelChangePage.class);
		pages.add(TransformationPage.class);
		pages.add(UseOrNotUsePropertyModelPage.class);
		pages.add(EmailFromComponentPage.class);
		pages.add(FormSubmitPage.class);
		pages.add(FormValidationPage.class);
		pages.add(JavascriptAjaxHeadContributorPage.class);
		pages.add(EventPage.class);
		pages.add(TransparentResolverPage.class);
		pages.add(LazyPanelPage.class);
		pages.add(NoTransparentResolverPage.class);
		pages.add(FormAutoCompletePage.class);
		pages.add(HeatMapPage.class);
		pages.add(AjaxJavascriptOverviewPage.class);
		pages.add(ModalWindowPage.class);
		pages.add(ParameterizedAjaxPage.class);
		pages.add(ComponentFactoryPage.class);
		pages.add(SeoAjaxLinksPage.class);
		pages.add(MergedResourcePage.class);
		pages.add(BackButtonStartPage.class);
		pages.add(AjaxRegionPage.class);
		
		pages.add(FirstRequestPage.class);

		add(new ListView<Class<? extends WebPage>>("list", pages) {

			@Override
			protected void populateItem(ListItem<Class<? extends WebPage>> item) {
				BookmarkablePageLink<WebPage> link = new BookmarkablePageLink<WebPage>("link", item.getModelObject());
				link.add(new Label("name", item.getModelObject().getSimpleName()));
				item.add(link);
			}
		});
	}
}
