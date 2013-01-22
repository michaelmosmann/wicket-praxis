package de.wicketpraxis.events;



public class GetCurrentCounterEvent extends AbstractEvent<Integer,ChangeCounterEvent> {

	public GetCurrentCounterEvent(ChangeCounterEvent source) {
		super(source);
	}

	@Override
	public String toString() {
		return "GetCurrentCounter";
	}
}
