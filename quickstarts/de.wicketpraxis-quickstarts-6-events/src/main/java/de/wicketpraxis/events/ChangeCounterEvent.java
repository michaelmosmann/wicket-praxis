package de.wicketpraxis.events;

public class ChangeCounterEvent extends AbstractChangeCounterEvent<Integer> {

	private final int _change;

	public ChangeCounterEvent(IEventBus eventBus, int change) {
		super(eventBus);
		_change = change;
	}

	public int getChange() {
		return _change;
	}
	
	@Override
	public String toString() {
		return "ChangeCounter("+_change+")";
	}
}
