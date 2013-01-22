package de.wicketpraxis.events;

public class SetCounterEvent extends AbstractEvent<Boolean> {

	private final int _newCounter;

	public SetCounterEvent(IEventBus eventBus, int newCounter) {
		super(eventBus);

		_newCounter = newCounter;
	}

	public int getNewCounter() {
		return _newCounter;
	}

}
