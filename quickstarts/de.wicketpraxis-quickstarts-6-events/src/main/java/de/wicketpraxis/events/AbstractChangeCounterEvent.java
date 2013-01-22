package de.wicketpraxis.events;


public abstract class AbstractChangeCounterEvent<T> extends AbstractEvent<T,NoEventBefore> {

	protected AbstractChangeCounterEvent(IEventBus eventBus) {
		super(eventBus);
	}

}
