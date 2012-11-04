package de.wicketpraxis.usecase.listview;

import de.wicketpraxis.usecase.AbstractStartPage;

public class UseCaseListView extends AbstractStartPage
{

	public UseCaseListView()
	{
		super("ListView",ListViewV1Page.class,ListViewV2Page.class);
	}

}
