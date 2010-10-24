/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.model.util.SetModel;
import org.apache.wicket.model.util.WildcardCollectionModel;
import org.apache.wicket.model.util.WildcardListModel;
import org.apache.wicket.model.util.WildcardSetModel;

public class ModelTypesPage extends WebPage
{
	public ModelTypesPage()
	{
		List<String> liste = Arrays.asList("Das", "ist", "ne", "Liste");
		Map<String, String> map = new HashMap<String, String>();

		IModel<Collection<String>> collectionModel = new CollectionModel<String>(liste);
		IModel<List<String>> listModel = new ListModel<String>(liste);
		IModel<Set<String>> setModel = new SetModel<String>(map.keySet());
		
//	IModel<Map<String, String>> mapModel = new MapModel<String, String>(map);
		IModel<Map<String, String>> mapModel = Model.ofMap(map);

//		IModel<Collection<? extends String>> wildcardCollectionModel = new WildcardCollectionModel<String>(liste);
		IModel<Collection<? extends String>> wildcardCollectionModel = Model.of((Collection<String>)liste);
//		IModel<List<? extends String>> wildcardListModel = new WildcardListModel<String>(liste);
		IModel<List<? extends String>> wildcardListModel = Model.of(liste);
//		IModel<Set<? extends String>> wildcardSetModel = new WildcardSetModel<String>(map.keySet());
		IModel<Set<? extends String>> wildcardSetModel = Model.of(map.keySet());

	}
}
