/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.awt.Color;
import java.awt.Font;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.resource.DefaultButtonImageResource;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Simple Dynamic Images")
public class SimpleDynamicImages extends WebPage {

	public SimpleDynamicImages() {
		add(new Image("ok", new DefaultButtonImageResource("Ok")));
		add(new Image("hallo", new DefaultButtonImageResource(122, 16, "Hallo")));
		DefaultButtonImageResource res = new DefaultButtonImageResource("Wicket");
		res.setWidth(140);
		res.setArcHeight(20);
		res.setArcWidth(20);
		res.setColor(new Color(10, 128, 250));
		res.setTextColor(new Color(0, 0, 0));
		res.setFont(new Font("Helvetica", Font.BOLD, 32));
		add(new Image("wicket", res));
	}
}
