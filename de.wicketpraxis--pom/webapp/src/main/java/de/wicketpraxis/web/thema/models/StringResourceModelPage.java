/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.model.StringResourceModel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "String Resource Model")
public class StringResourceModelPage extends WebPage {

	public StringResourceModelPage() {
		add(new Label("text", new ResourceModel("test.text")));

		DummyBean bean = new DummyBean();
		bean.setName("textA");

		add(new Label("textA", new StringResourceModel("test.${name}", Model.of(bean))));
		add(new Label("textB", new StringResourceModel("test.textB", Model.of(bean))));

		Object[] parameter = {new Date(), Model.of(1.23456789)};
		add(new Label("textC", new StringResourceModel("test.textC", Model.of(bean), parameter)));

	}
}
