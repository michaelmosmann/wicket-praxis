/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.resource.IStringResourceStream;
import org.apache.wicket.util.resource.StringBufferResourceStream;
import org.apache.wicket.velocity.markup.html.VelocityPanel;

import de.wicketpraxis.web.thema.TitleAnnotation;

/**
 * @see http://www.wicket-library.com/wicket-examples/velocity/
 */
@TitleAnnotation(title = "Velocity Panel")
public class VelocityPanelPage extends WebPage {

	public VelocityPanelPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zahl", 3.123456d);
		map.put("text", "etwas Text");
		map.put("id", "label");

		IModel<? extends Map<?, ?>> model = Model.ofMap(map);
		VelocityPanel panel = new VelocityPanel("velocity", model) {

			@Override
			protected IStringResourceStream getTemplateResource() {
				//				return new PackageResourceStream(VelocityPanelPage.class,"template.vm");

				StringBufferResourceStream ret = new StringBufferResourceStream();
				ret.append("Text mit ${zahl} und ${text}.");
				ret.append(" <span wicket:id=\"${id}\"></span>");
				return ret;
			}

			@Override
			protected boolean parseGeneratedMarkup() {
				return true;
			}
		};
		add(panel);

		panel.add(new Label("label", "Wicket Label"));

	}
}
