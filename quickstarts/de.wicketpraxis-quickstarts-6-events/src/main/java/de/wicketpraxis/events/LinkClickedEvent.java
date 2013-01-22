package de.wicketpraxis.events;

public class LinkClickedEvent extends AbstractEvent<Integer> {

	private final int _counter;

	public LinkClickedEvent(IEventBus eventBus, int counter) {
		super(eventBus);
		_counter = counter;
	}

	public int getCounter() {
		return _counter;
	}
}
