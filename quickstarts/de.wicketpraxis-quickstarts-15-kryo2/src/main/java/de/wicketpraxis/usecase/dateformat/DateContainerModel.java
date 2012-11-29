package de.wicketpraxis.usecase.dateformat;

import java.util.Date;

import org.apache.wicket.model.LoadableDetachableModel;

public class DateContainerModel extends LoadableDetachableModel<AbstractDateContainer>
{
	private final boolean full;

	public DateContainerModel(boolean full)
	{
		this.full = full;
	}

	@Override
	protected AbstractDateContainer load()
	{
		return full ? new FullDate(new Date()) : new SmallDate(new Date());
	}
}