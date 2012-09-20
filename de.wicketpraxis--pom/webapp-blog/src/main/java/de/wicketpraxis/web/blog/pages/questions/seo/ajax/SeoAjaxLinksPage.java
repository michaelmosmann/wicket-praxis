package de.wicketpraxis.web.blog.pages.questions.seo.ajax;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SeoAjaxLinksPage extends WebPage {

	IModel<Integer> _countModel=Model.of(0);
	
	public SeoAjaxLinksPage(PageParameters pageParameters) {
		
		int count = getCounter(pageParameters);
		_countModel.setObject(count);
		
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		final Label label = new Label("counter",_countModel);
		label.setOutputMarkupId(true);
		add(label);

		add(new AjaxBookmarkablePageLink<Void>("link", getClass(), new PageParameters().add("Count",count)) {

			@Override
			protected void onclick(AjaxRequestTarget target) {
				target.add(feedbackPanel);
				target.add(label);
				target.add(this);
				
				int count=getCounter(getPageParameters());
				_countModel.setObject(count);
				getPageParameters().set("Count", count+1);
				
				info("Count: "+count);
			}
		}.setOutputMarkupId(true));
		
	}

	private int getCounter(PageParameters pageParameters) {
		return pageParameters.get("Count").toInt(0);
	}
}
