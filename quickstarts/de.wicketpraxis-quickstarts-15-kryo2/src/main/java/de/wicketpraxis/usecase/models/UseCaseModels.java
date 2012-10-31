package de.wicketpraxis.usecase.models;

import de.wicketpraxis.usecase.AbstractStartPage;

public class UseCaseModels extends AbstractStartPage
{

	public UseCaseModels()
	{
		super("Models",ModelsV1Page.class,ModelsV2Page.class);
	}

}
