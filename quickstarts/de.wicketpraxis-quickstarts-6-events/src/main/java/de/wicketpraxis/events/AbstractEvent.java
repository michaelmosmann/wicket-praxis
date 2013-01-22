package de.wicketpraxis.events;

import org.apache.wicket.Component;

public abstract class AbstractEvent<T> {

	private final IEventBus _eventBus;
	T _response;

	public AbstractEvent(IEventBus eventBus) {
		_eventBus = eventBus;
	}
	
	public T send() {
		_eventBus.send(this);
		return _response;
	}
	
	public void respondWith(T response) {
		_response=response;
	}
	
	public void update(Component component) {
		_eventBus.updater().update(component);
	}

	public IEventBus asReply() {
		return _eventBus.asReply();
	}
}
