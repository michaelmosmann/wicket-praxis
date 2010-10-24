package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.DefaultCssAutocompleteTextField;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class FormAutoCompletePage extends WebPage
{
	public FormAutoCompletePage()
	{
		add(CSSPackageResource.getHeaderContribution(DefaultCssAutocompleteTextField.class,"DefaultCssAutocompleteTextField.css"));
		
		Form<Void> form = new Form<Void>("form");
		
		TextField<String> plz = new TextField<String>("plz",Model.of(""));
		TextField<String> ort = new TextField<String>("ort",Model.of(""));
		
		plz.add(new PlzAutoCompleteBehavior(new PlzOrtListFactory(),ort));
		
		form.add(plz);
		form.add(ort);
		
		add(form);
	}
}
