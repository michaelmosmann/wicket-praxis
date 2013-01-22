package de.wicketpraxis;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.wicketpraxis.events.AbstractEvent;
import de.wicketpraxis.events.Events;
import de.wicketpraxis.events.GetCurrentCounterEvent;
import de.wicketpraxis.events.IEventBus;
import de.wicketpraxis.events.LinkClickedEvent;
import de.wicketpraxis.events.SetCounterEvent;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 * 
 * @see de.wicketpraxis.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here
	}

	@Override
	public void onEvent(IEvent<?> event) {
		AbstractEvent<?> e = Events.asEvent(event);
		if (e instanceof LinkClickedEvent) {
			LinkClickedEvent le = (LinkClickedEvent) e;

			Integer currentCounter = new GetCurrentCounterEvent(e.asReply()).send();
			if (currentCounter == null) {
				currentCounter = 0;
			}
			currentCounter = currentCounter + le.getCounter();

			Boolean set = new SetCounterEvent(e.asReply(),currentCounter).send();
			if (set == null && !set) {
				le.respondWith(null);
			} else {
				le.respondWith(currentCounter);
			}
		}
	}
}
