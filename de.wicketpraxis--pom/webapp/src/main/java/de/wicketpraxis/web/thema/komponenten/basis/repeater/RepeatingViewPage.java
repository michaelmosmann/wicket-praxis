/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.RepeatingView;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Repeating View")
public class RepeatingViewPage extends WebPage {

	public RepeatingViewPage() {
		RepeatingView repeatingView = new RepeatingView("list");
		for (int i = 0; i < 10; i++) {
			repeatingView.add(new Label(repeatingView.newChildId(), "Zeile " + i));
		}
		add(repeatingView);
	}
}
