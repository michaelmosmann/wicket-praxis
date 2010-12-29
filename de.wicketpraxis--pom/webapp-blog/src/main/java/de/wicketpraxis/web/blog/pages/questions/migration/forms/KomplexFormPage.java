package de.wicketpraxis.web.blog.pages.questions.migration.forms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

public class KomplexFormPage extends WebPage {

	public KomplexFormPage() {
		add(new FeedbackPanel("feedback"));

		Form<FormBean> form = new Form<FormBean>("form", new CompoundPropertyModel<FormBean>(new FormBean())) {

			@Override
			protected void onSubmit() {
				// Variante 1
				setResponsePage(new ResultPage(getModelObject().getName()));

				// Variante 2
				Map<String, String> map = new HashMap<String, String>();
				map.put("Name", getModelObject().getName());
				setResponsePage(ResultPage.class, new PageParameters(map));

				// Variante ?
			}
		};

		form.add(new TextField<String>("Name").setRequired(true));

		add(form);
	}
}
