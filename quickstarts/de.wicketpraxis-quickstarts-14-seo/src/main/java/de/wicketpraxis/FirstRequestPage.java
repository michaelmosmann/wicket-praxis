package de.wicketpraxis;

import org.apache.wicket.PageParameters;
import org.apache.wicket.Request;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.target.coding.QueryStringUrlCodingStrategy;

public class FirstRequestPage extends WebPage {

	public FirstRequestPage(PageParameters pageParameters) {
		setStatelessHint(false);

		Model<Integer> counter = Model.of(0);
		final Label label=new Label("counter",counter);
		label.setOutputMarkupId(true);
		add(label);
		add(new AjaxLink<Integer>("ajax",counter) {

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.addComponent(label);
				setModelObject(getModelObject()+1);
			}
		});

		add(new BookmarkablePageLink<FirstRequestPage>("bookmark", FirstRequestPage.class, new PageParameters("param=fromBookmarkable")));
		add(new Link<Void>("link") {
			@Override
			public void onClick() {
				
			}
		});
		add(new Link<Void>("redirectLink") {
			@Override
			public void onClick() {
				setResponsePage(FirstRequestPage.class,new PageParameters("param=fromLink"));
			}
		});
	}

	public static void mountPage(WicketApplication app) {
		app.mount(new QueryStringUrlCodingStrategy("firstPage", FirstRequestPage.class));
	}
}
