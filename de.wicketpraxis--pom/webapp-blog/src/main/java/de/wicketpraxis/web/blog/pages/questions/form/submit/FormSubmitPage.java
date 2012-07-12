package de.wicketpraxis.web.blog.pages.questions.form.submit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxFallbackButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

public class FormSubmitPage extends WebPage {

	int _counter;

	public FormSubmitPage() {
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		CompoundPropertyModel<FormBean> formModel = new CompoundPropertyModel<FormBean>(new FormBean());
		Form<FormBean> form = new Form<FormBean>("form", formModel) {

			@Override
			protected void onSubmit() {
				info("Form Submit: " + _counter++);
			}
		};

		form.add(new TextField<String>("name"));

		form.add(new Button("defaultSubmit") {

			@Override
			public void onSubmit() {
				info("Default Button: " + _counter++);
			}
		});

		form.add(new Button("submit") {

			@Override
			public void onSubmit() {
				info("Button: " + _counter++);
			}
		});

		form.add(new AjaxFallbackButton("ajaxSubmit", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				if (target != null) {
					info("AjaxSubmit Button(ajax): " + _counter++);
					target.addComponent(feedbackPanel);

					_counter = 0;
				} else {
					info("AjaxFallbackButton: " + _counter++);
				}
			}
			
			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				
			}
		});

		add(form);
	}

	@Override
	protected void onBeforeRender() {
		_counter = 0;
		super.onBeforeRender();
	}
}
