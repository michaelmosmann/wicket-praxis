package de.wicketpraxis.events;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;


public class Events {

	public static IEventBus from(Component source) {
		return from(source,null);
	}
	
	public static IEventBus from(Component source, AjaxRequestTarget target) {
		return new ComponentEventBus(source,target);
	}
	
	public static AbstractEvent<?> asEvent(IEvent<?> event) {
		if (event.getPayload() instanceof AbstractEvent) {
			return (AbstractEvent<?>) event.getPayload();
		}
		return null;
	}

	static class ComponentEventBus implements IEventBus {

		private final Component _source;
		private final AjaxRequestTarget _target;
		private IComponentUpdater _updater;

		public ComponentEventBus(Component source, AjaxRequestTarget target) {
			_source = source;
			_target = target;
			_updater = target!=null ? new AjaxTargetUpdater(target) : new NoopUpdater();
		}

		@Override
		public void send(AbstractEvent<?> event) {
			_source.send(_source, Broadcast.BUBBLE, event);
		}
		
		@Override
		public IEventBus asReply() {
			return new PageEventBus(_source.getPage(),_updater);
		}
		
		@Override
		public IComponentUpdater updater() {
			return _updater;
		}
	}
	
	static class PageEventBus implements IEventBus {

		private final Page _page;
		private final IComponentUpdater _updater;

		public PageEventBus(Page page, IComponentUpdater updater) {
			_page = page;
			_updater = updater;
		}

		@Override
		public void send(AbstractEvent<?> event) {
			_page.send(_page, Broadcast.BREADTH, event);
		}
		
		@Override
		public IEventBus asReply() {
			return null;
		}
		
		@Override
		public IComponentUpdater updater() {
			return _updater;
		}
	}
	
	static class NoopUpdater implements IComponentUpdater {

		@Override
		public void update(Component component) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	static class AjaxTargetUpdater implements IComponentUpdater {

		private final AjaxRequestTarget _target;

		public AjaxTargetUpdater(AjaxRequestTarget target) {
			_target = target;
		}

		@Override
		public void update(Component component) {
			_target.add(component);
		}
		
	}
}
