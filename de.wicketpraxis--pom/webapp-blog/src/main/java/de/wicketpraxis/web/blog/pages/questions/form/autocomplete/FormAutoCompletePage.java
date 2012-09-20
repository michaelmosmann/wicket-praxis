package de.wicketpraxis.web.blog.pages.questions.form.autocomplete;

import org.apache.wicket.extensions.ajax.markup.html.autocomplete.DefaultCssAutoCompleteTextField;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

public class FormAutoCompletePage extends WebPage {

	public FormAutoCompletePage() {
		Form<Void> form = new Form<Void>("form");

		TextField<String> plz = new TextField<String>("plz", Model.of(""));
		TextField<String> ort = new TextField<String>("ort", Model.of(""));

		plz.add(new PlzAutoCompleteBehavior(new PlzOrtListFactory(), ort));

		form.add(plz);
		form.add(ort);

		add(form);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssReferenceHeaderItem.forReference(new PackageResourceReference(DefaultCssAutoCompleteTextField.class,
				"DefaultCssAutocompleteTextField.css")));
	}
}
