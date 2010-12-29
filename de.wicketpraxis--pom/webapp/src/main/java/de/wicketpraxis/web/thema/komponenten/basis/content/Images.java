/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.Application;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.image.Image;

import sun.security.action.GetLongAction;

public enum Images {
	TEST1("test1.gif"),
	TEST2("test2.gif"),
	TEST3("test3.gif");

	String _name;

	private Images(String name) {
		_name = name;
	}

	public Image newImage(String id) {
		Session session = Session.get();
		return new Image(id, new ResourceReference(getClass(), _name, session.getLocale(), session.getStyle()));
	}
}
