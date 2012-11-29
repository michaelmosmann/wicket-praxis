package de.wicketpraxis.usecase.dateformat;

import java.util.Date;

import org.apache.wicket.model.LoadableDetachableModel;

public class DateModel extends LoadableDetachableModel<Date>
{
	@Override
	protected Date load()
	{
		return new Date();
	}
}