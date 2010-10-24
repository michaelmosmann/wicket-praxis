/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import static de.wicketpraxis.web.thema.komponenten.basis.content.Images.TEST1;
import static de.wicketpraxis.web.thema.komponenten.basis.content.Images.TEST2;
import static de.wicketpraxis.web.thema.komponenten.basis.content.Images.TEST3;

import org.apache.wicket.markup.html.WebPage;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="Images as Enums")
public class ImageAsEnumPage extends WebPage
{
	public ImageAsEnumPage()
	{
		add(TEST1.newImage("i1"));
		add(TEST2.newImage("i2"));
		add(TEST3.newImage("i3"));
	}
}
