/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.WildcardListModel;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Serializable Models")
public class SerializableModelPage extends WebPage {

	public SerializableModelPage() {
		//		IModel<List<? extends Serializable>> message=new WildcardListModel<Serializable>(Arrays.asList("Eins",(Serializable) 2,3.0d));
		IModel<List<? extends Serializable>> message = Model.ofList(Arrays.asList("Eins", (Serializable) 2, 3.0d));

		add(new Label("message", message));
	}
}
