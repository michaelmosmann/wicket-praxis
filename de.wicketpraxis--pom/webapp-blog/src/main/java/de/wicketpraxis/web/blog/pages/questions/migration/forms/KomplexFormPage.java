package de.wicketpraxis.web.blog.pages.questions.migration.forms;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class KomplexFormPage extends WebPage {

	public KomplexFormPage() {
		add(new FeedbackPanel("feedback"));

		Form<FormBean> form = new Form<FormBean>("form", new CompoundPropertyModel<FormBean>(new FormBean())) {

			@Override
			protected void onSubmit() {
				// Variante 1
				setResponsePage(new ResultPage(getModelObject().getName()));

				// Variante 2
				PageParameters map = new PageParameters();
				map.add("Name", getModelObject().getName());
				setResponsePage(ResultPage.class, new PageParameters(map));

				// Variante ?
			}
		};

		form.add(new TextField<String>("Name").setRequired(true));

		add(form);
	}
}
