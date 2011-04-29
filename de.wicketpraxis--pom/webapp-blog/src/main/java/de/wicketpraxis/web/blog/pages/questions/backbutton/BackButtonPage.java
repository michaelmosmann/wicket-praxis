package de.wicketpraxis.web.blog.pages.questions.backbutton;

import java.util.Date;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.protocol.http.WebResponse;

public class BackButtonPage extends WebPage {

	static final TimeStampKey KEY = new TimeStampKey();
	private long _pageInitTimeStamp;

	public BackButtonPage() {
		//setVersioned(true);

		_pageInitTimeStamp = new Date().getTime();
		setPageTimeStamp(_pageInitTimeStamp);

		add(new FeedbackPanel("feedback"));

		add(new Link<Void>("link") {

			@Override
			public void onClick() {
				setResponsePage(new BackButtonPage());
			}
		});
	}

	private static void setPageTimeStamp(long timeStamp) {
		Session.get().setMetaData(KEY, timeStamp);
	}

	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();

		Long lastPageRendered = Session.get().getMetaData(KEY);
		setPageTimeStamp(_pageInitTimeStamp);

		if (lastPageRendered > _pageInitTimeStamp) {
			info("BackButton pressed");
		}
		if (lastPageRendered < _pageInitTimeStamp) {
			info("ForwardButton pressed");
		}
	}

	@Override
	protected void configureResponse() {
		super.configureResponse();
		WebResponse response = getWebRequestCycle().getWebResponse();
		response.setHeader("Cache-Control", "no-cache, max-age=0,must-revalidate, no-store");
	}

	static class TimeStampKey extends MetaDataKey<Long> {

	}
}
