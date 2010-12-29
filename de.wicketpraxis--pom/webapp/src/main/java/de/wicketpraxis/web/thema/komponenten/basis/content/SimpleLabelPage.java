/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Labels")
public class SimpleLabelPage extends WebPage {

	public SimpleLabelPage() {
		IModel<String> text = Model.of("Text und <strong>Html</strong><br>\n wird unterschiedlich dargestellt.");

		add(new Label("text", text));
		add(new Label("textMitHtml", text).setEscapeModelStrings(false));

		IModel<String> texte = Model.of("Text und <strong>Html</strong>\n wird unterschiedlich dargestellt.\n\nZweiter Absatz.");
		add(new MultiLineLabel("texte", texte));
		add(new MultiLineLabel("texteMitHtml", texte).setEscapeModelStrings(false));
	}
}
