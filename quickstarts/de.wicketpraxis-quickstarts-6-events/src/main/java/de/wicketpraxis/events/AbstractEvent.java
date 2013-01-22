package de.wicketpraxis.events;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;

public abstract class AbstractEvent<T,S extends AbstractEvent<?, ?>> {

	private final IEventBus _eventBus;
	
	boolean _hasResponse=false;
	T _response;
	private S _source;

	protected AbstractEvent(IEventBus eventBus) {
		_eventBus = eventBus;
	}

	protected AbstractEvent(S source) {
		_eventBus = source._eventBus.asReply();
		_source=source;
	}
	
	public T send() {
		_eventBus.send(this);
		if (!_hasResponse) throw new WicketRuntimeException("Nobody did respond to Event "+asPath());
		return _response;
	}
	
	public void respondWith(T response) {
		_response=response;
		_hasResponse=true;
	}
	
	public void update(Component component) {
		_eventBus.updater().update(component);
	}
	
	public S getSource() {
		return _source;
	}
	
	public List<AbstractEvent<?,?>> asPath() {
		ArrayList<AbstractEvent<?, ?>> ret = new ArrayList<AbstractEvent<?,?>>();
		asPath(ret);
		return ret;
	}

	private void asPath(ArrayList<AbstractEvent<?, ?>> list) {
		if (_source!=null) {
			_source.asPath(list);
		}
		list.add(this);
	}
}
