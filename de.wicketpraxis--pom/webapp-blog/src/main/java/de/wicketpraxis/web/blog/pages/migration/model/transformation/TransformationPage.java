package de.wicketpraxis.web.blog.pages.migration.model.transformation;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

import de.wicketpraxis.wicket.model.Models;
import de.wicketpraxis.wicket.model.transformation.Function1;
import de.wicketpraxis.wicket.model.transformation.Function2;

public class TransformationPage extends WebPage {

	public TransformationPage() {
		IModel<Double> randModel1 = new RandomNumberModel();
		IModel<Double> randModel2 = new RandomNumberModel();

		IModel<Double> diffResult = Models.on(randModel1, randModel2).apply(new Function2<Double, Double, Double>() {

			public Double apply(Double value, Double value2) {
				return value - value2;
			}
		});

		IModel<Integer> scaleResult = Models.on(randModel1).apply(new Function1<Integer, Double>() {

			public Integer apply(Double value) {
				return (int) (value * 100);
			}
		});

		WebMarkupContainer ajaxUpdate = new WebMarkupContainer("ajaxUpdate");
		ajaxUpdate.setOutputMarkupId(true);
		ajaxUpdate.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));

		ajaxUpdate.add(new Label("rand1", randModel1));
		ajaxUpdate.add(new Label("rand2", randModel2));
		ajaxUpdate.add(new Label("diffResult", diffResult));
		ajaxUpdate.add(new Label("scaleResult", scaleResult));

		add(ajaxUpdate);
	}
}
