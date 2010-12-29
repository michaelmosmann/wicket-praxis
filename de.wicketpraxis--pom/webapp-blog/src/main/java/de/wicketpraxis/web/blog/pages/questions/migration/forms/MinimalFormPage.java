package de.wicketpraxis.web.blog.pages.questions.migration.forms;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class MinimalFormPage extends WebPage {

	public MinimalFormPage() {
		Form<FormBean> form = new Form<FormBean>("form", new CompoundPropertyModel<FormBean>(new FormBean()));

		form.add(new TextField<String>("Name"));

		add(form);
	}
}
