package de.wicketpraxis.events;


public class GetCurrentCounterEvent extends AbstractEvent<Integer> {

	public GetCurrentCounterEvent(IEventBus eventBus) {
		super(eventBus);
	}

}
