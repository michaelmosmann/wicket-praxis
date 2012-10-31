package de.wicketpraxis.usecase.anonclasses;

import de.wicketpraxis.usecase.AbstractStartPage;

public class UseCaseAnonClasses extends AbstractStartPage
{

	public UseCaseAnonClasses()
	{
		super("Models",AnonClassesV1Page.class,AnonClassesV2Page.class);
	}

}
