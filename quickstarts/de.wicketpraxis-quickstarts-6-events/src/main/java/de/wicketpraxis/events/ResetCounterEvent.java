package de.wicketpraxis.events;


public class ResetCounterEvent extends AbstractChangeCounterEvent<Integer> {

	public ResetCounterEvent(IEventBus eventBus) {
		super(eventBus);
	}
	
	@Override
	public String toString() {
		return "ResetCounter";
	}
}
