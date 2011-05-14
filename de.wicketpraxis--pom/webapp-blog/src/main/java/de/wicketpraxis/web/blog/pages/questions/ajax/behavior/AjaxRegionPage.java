package de.wicketpraxis.web.blog.pages.questions.ajax.behavior;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;


public class AjaxRegionPage extends WebPage {

	
	private Model<Integer> _counter;

	public AjaxRegionPage() {
		
		_counter = Model.of(0);
		final Label label=new Label("label",_counter);
		label.setOutputMarkupId(true);
		label.add(new AjaxRegionBehavior());
		add(label);
		
		add(new AjaxLink<Integer>("link",_counter) {
			@Override
			public void onClick(AjaxRequestTarget target) {
				setModelObject(1+getModelObject());
				target.addComponent(label);
			}
		});
	}
}
