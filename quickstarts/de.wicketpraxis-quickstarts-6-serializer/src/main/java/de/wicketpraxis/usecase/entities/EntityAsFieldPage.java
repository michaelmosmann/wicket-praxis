package de.wicketpraxis.usecase.entities;

import org.apache.wicket.markup.html.WebPage;

public class EntityAsFieldPage extends WebPage {

	MyEntity shouldNotBeSerialized = new MyEntity();

	public EntityAsFieldPage() {

		setStatelessHint(false);
	}

	static class MyEntity implements IEntity {

	}
}
