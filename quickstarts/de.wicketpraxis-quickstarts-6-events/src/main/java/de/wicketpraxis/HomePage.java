package de.wicketpraxis;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.components.CounterPanel;
import de.wicketpraxis.components.ChangeCounterPanel;
import de.wicketpraxis.components.ResetCounterPanel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here
		add(new CounterPanel("counter"));
		add(new ChangeCounterPanel("add",1));
		add(new ChangeCounterPanel("sub",-1));
		add(new ResetCounterPanel("reset"));

    }
}
