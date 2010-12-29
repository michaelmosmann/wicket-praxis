/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.modify2;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.howto.modify2.ButtonLink.Type;

@TitleAnnotation(title = "eigene Versionen von Standardkomponenten")
public class OwnComponentsPage extends WebPage {

	public OwnComponentsPage() {
		add(new CustomFeedbackPanel("feedback"));

		//		info("Info1");
		//		warn("warn1");
		//		error("error");
		//		debug("debug1");
		//		info("Info2");
		//		warn("warn2");
		//		error("error1");

		add(new ButtonLink<String>("ok", Model.of(":)"), Type.OK) {

			@Override
			public void onClick() {
				info("ok");
			}
		});

		add(new ButtonLink<String>("info", Model.of("!"), Type.INFO) {

			@Override
			public void onClick() {
				warn("aufgepasst");
			}
		});

		add(new ButtonLink<String>("cancel", Model.of(":("), Type.CANCEL) {

			@Override
			public void onClick() {
				error("cancel");
			}
		});
	}
}
