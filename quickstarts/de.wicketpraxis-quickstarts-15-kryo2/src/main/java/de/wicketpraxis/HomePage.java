package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.wicketpraxis.usecase.anonclasses.UseCaseAnonClasses;
import de.wicketpraxis.usecase.dateformat.UseCaseDateFormat;
import de.wicketpraxis.usecase.finals.UseCaseFinals;
import de.wicketpraxis.usecase.listview.UseCaseListView;
import de.wicketpraxis.usecase.models.UseCaseModels;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        		
		add(AutoLabelBookmarkablePageLink.with("dateformat", UseCaseDateFormat.class));
		add(AutoLabelBookmarkablePageLink.with("models", UseCaseModels.class));
		add(AutoLabelBookmarkablePageLink.with("anonclasses", UseCaseAnonClasses.class));
		add(AutoLabelBookmarkablePageLink.with("listview", UseCaseListView.class));
		add(AutoLabelBookmarkablePageLink.with("finals", UseCaseFinals.class));
    }
}
