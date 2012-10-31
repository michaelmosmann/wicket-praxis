package de.wicketpraxis;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.wicketpraxis.components.BigComponent;
import de.wicketpraxis.usecase.dateformat.UseCaseDateFormat;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        
		Model<Integer> model = Model.of(1);
		add(new Label("label",model));
		add(new Link<Integer>("link",model) {
			@Override
			public void onClick() {
				setModelObject(1+getModelObject());
			}
		});
		
		add(new BigComponent("a6", 6*1024*1024));
		add(new BigComponent("a4", 4*1024*1024));
		
		add(AutoLabelBookmarkablePageLink.with("dateFormat", UseCaseDateFormat.class));
    }
}
