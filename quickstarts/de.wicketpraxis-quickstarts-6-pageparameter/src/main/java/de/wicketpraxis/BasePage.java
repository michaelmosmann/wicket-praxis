package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class BasePage extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();
		getPageParameters().set(0, "bla");
	}
	
	@Override
	public ReadOnlyPageParameters getPageParameters() {
		return new ReadOnlyPageParameters(super.getPageParameters());
	}
}
