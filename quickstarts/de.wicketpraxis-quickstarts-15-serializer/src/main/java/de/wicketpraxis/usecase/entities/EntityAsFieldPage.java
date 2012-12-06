package de.wicketpraxis.usecase.entities;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import de.wicketpraxis.serializer.IEntity;

public class EntityAsFieldPage extends WebPage {

	MyEntity shouldNotBeSerialized=new MyEntity();
	
	public EntityAsFieldPage() {
		
		setStatelessHint(false);
	}

	static class MyEntity implements IEntity {
		
	}
}

