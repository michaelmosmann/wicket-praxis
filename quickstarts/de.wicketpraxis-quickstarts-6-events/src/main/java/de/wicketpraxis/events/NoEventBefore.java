package de.wicketpraxis.events;

public class NoEventBefore extends AbstractEvent<Void, NoEventBefore> {

	private NoEventBefore(NoEventBefore source) {
		super(source);
	}

}
