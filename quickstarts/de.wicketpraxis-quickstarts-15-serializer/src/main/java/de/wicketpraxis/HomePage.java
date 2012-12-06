package de.wicketpraxis;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.usecase.entities.UseCaseEntities;
import de.wicketpraxis.usecase.models.UseCaseModels;
import de.wicketpraxis.usecase.replacements.UseCaseReplacements;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		add(AutoLabelBookmarkablePageLink.with("models", UseCaseModels.class));
		add(AutoLabelBookmarkablePageLink.with("replacements", UseCaseReplacements.class));
		add(AutoLabelBookmarkablePageLink.with("entities", UseCaseEntities.class));
	}
}
