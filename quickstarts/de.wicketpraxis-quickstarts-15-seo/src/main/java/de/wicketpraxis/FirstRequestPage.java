package de.wicketpraxis;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.handler.PageProvider;
import org.apache.wicket.request.handler.RenderPageRequestHandler;
import org.apache.wicket.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.request.mapper.MountedMapper;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
				target.add(label);
				setModelObject(getModelObject()+1);
			}
		});

		add(new BookmarkablePageLink<FirstRequestPage>("bookmark", FirstRequestPage.class, new PageParameters().add("param","fromBookmarkable")));
		add(new Link<Void>("link") {
			@Override
			public void onClick() {
				
			}
		});
		add(new Link<Void>("redirectLink") {
			@Override
			public void onClick() {
				setResponsePage(FirstRequestPage.class,new PageParameters().add("param","fromLink"));
			}
		});
	}

	public static IRequestMapper defaultMapper() {
		return new MountedMapper("firstPage",FirstRequestPage.class) {
			@Override
			public IRequestHandler mapRequest(Request request) {
				return super.mapRequest(request);
			}
			
			@Override
			protected IRequestHandler processBookmarkable(Class<? extends IRequestablePage> pageClass,
					PageParameters pageParameters) {				
				PageProvider provider = new PageProvider(pageClass, pageParameters);
				provider.setPageSource(getContext());
				return new RenderPageRequestHandler(provider,RedirectPolicy.NEVER_REDIRECT);
			}
		};
	}
}
