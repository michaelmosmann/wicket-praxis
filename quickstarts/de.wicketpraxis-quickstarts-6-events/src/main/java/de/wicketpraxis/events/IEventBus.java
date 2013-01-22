package de.wicketpraxis.events;


public interface IEventBus {
	public void send(AbstractEvent<?> event);

	public IEventBus asReply();
	
	public IComponentUpdater updater();
}
