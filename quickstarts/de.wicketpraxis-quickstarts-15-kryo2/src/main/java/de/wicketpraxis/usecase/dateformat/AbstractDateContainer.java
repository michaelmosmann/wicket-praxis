package de.wicketpraxis.usecase.dateformat;

import java.util.Date;

public abstract class AbstractDateContainer
{
	private final Date value;

	public AbstractDateContainer(Date value)
	{
		this.value = value;
	}

	public Date getValue()
	{
		return value;
	}
}
