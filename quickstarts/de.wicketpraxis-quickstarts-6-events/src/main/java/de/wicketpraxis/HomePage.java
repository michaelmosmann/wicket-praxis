package de.wicketpraxis;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.components.CounterPanel;
import de.wicketpraxis.components.LinkPanel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		add(new CounterPanel("counter"));
		add(new LinkPanel("add",1));
		add(new LinkPanel("sub",-1));

    }
}
