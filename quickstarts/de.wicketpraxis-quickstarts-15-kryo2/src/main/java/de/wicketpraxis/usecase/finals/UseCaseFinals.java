package de.wicketpraxis.usecase.finals;

import de.wicketpraxis.usecase.AbstractStartPage;

public class UseCaseFinals extends AbstractStartPage
{

	public UseCaseFinals()
	{
		super("Finals", FinalsV1Page.class, FinalsV2Page.class);
	}
}
