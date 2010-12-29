package de.wicketpraxis.web.blog.pages.questions.factories;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class LabelFactory implements IComponentFactory<Label> {

	IModel<?> _model;

	public LabelFactory(IModel<?> model) {
		_model = model;
	}

	public Label newComponent(String id) {
		return new Label(id, _model);
	}
}
