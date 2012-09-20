package de.wicketpraxis;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ReadOnlyPageParameters extends PageParameters {

	public ReadOnlyPageParameters(PageParameters pageParameters) {
		super(pageParameters);
	}
	
	@Override
	public NotReachablePageParameters set(int index, Object object) {
		return noSet();
	}
	
	

	private NotReachablePageParameters noSet() throws IllegalAccessError {
		throw new IllegalAccessError("set not allowed");
	}

	
	private static class NotReachablePageParameters extends PageParameters {
		
	}
}
