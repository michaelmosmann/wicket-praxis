/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.modify2;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

public abstract class ButtonLink<T> extends Link<T> {

	public enum Type {
		OK,
		INFO,
		CANCEL
	};

	public ButtonLink(String id, IModel<T> model, Type type) {
		super(id, model);

		add(new AttributeModifier("class", true, Model.of(type.name())));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.renderCSSReference(new PackageResourceReference(ButtonLink.class, "button.css"));
	}
}
