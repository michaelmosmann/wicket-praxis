package de.wicketpraxis.events;

public class SetCounterEvent extends AbstractEvent<Boolean,AbstractChangeCounterEvent<?>> {

	private final int _newCounter;

	public SetCounterEvent(AbstractChangeCounterEvent<?> source, int newCounter) {
		super(source);

		_newCounter = newCounter;
	}

	public int getNewCounter() {
		return _newCounter;
	}
	
	@Override
	public String toString() {
		return "SetCounter("+_newCounter+")";
	}

}
