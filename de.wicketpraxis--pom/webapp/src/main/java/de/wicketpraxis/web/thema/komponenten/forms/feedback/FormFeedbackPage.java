/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.feedback;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class FormFeedbackPage extends AbstractFormPage {

	public FormFeedbackPage() {
		Form<?> f1 = new Form<Void>("form1");
		f1.add(new TextField<String>("Text", new Model()).setRequired(true));
		add(f1);
		Form<?> f2 = new Form<Void>("form2");
		f2.add(new TextField<String>("Text", new Model()).setRequired(true));
		add(f2);

		add(new FeedbackPanel("feedback1", new ContainerFeedbackMessageFilter(f1)));
		add(new FeedbackPanel("feedback2", new ContainerFeedbackMessageFilter(f2)));
	}
}
