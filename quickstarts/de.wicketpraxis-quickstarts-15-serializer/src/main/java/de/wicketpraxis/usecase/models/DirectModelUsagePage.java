package de.wicketpraxis.usecase.models;

import java.util.Date;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class DirectModelUsagePage extends WebPage {

	public DirectModelUsagePage() {

		final IModel<Date> dateModel = new LoadableDetachableModel<Date>() {

			@Override
			protected Date load() {
				return new Date();
			}
		};

		add(new WebMarkupContainer("now") {
			@Override
			public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
				replaceComponentTagBody(markupStream, openTag, ""+dateModel.getObject());
			}
		});

		setStatelessHint(false);
	}

}
