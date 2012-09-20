/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.req;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReqZyklusPage extends WebPage {

	private static final Logger _logger = LoggerFactory.getLogger(ReqZyklusPage.class);

	public ReqZyklusPage() {
		_logger.info("Constructor");
		add(new MyPanel("p1"));
		add(new MyPanel("p2").setVisible(false));
	}

	static class MyPanel extends Panel {

		public MyPanel(String id) {
			super(id);
		}

		// not request cycle
		@Override
		protected void onInitialize() {
			_logger.error("onInitialize {}", getId());
			super.onInitialize();
		}
		
		@Override
		protected void onRemove() {
			_logger.error("onRemove {}", getId());
			super.onRemove();
		}
		
		@Override
		public void onEvent(IEvent<?> event) {
			_logger.error("onEvent {}", getId());
			super.onEvent(event);
		}
		
		// request cycle
		@Override
		protected void onConfigure() {
			_logger.error("onConfigure {}", getId());
			super.onConfigure();
		}
		
		@Override
		protected void onRender() {
			_logger.error("onRender {}", getId());
			super.onRender();
		}

		@Override
		protected void onBeforeRender() {
			_logger.error("onBeforeRender {}", getId());
			super.onBeforeRender();
		}

		@Override
		protected void onAfterRenderChildren() {
			_logger.error("onAfterRenderChildren {}", getId());
			super.onAfterRenderChildren();
		}
		
		@Override
		protected void onAfterRender() {
			_logger.error("onAfterRender {}", getId());
			super.onAfterRender();
		}

		
		
		@Override
		protected void onDetach() {
			_logger.error("onDetach {}", getId());
			super.onDetach();
		}
	}
}
