/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.Page;
import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.IRequestHandler;

import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.mapper.helper.impl.ObjectMapper;
import com.sdicons.json.model.JSONValue;

public class RenderJSON {

	Page _page;

	private RenderJSON(Page page) {
		_page = page;
	}

	public static RenderJSON onPage(Page page) {
		return new RenderJSON(page);
	}

	public <T> void with(T bean) throws MapperException {
		render(_page, bean);
	}

	static <T> void render(Page page, T bean) throws MapperException {
		final JSONValue json = new ObjectMapper().toJSON(bean);

		page.getRequestCycle().scheduleRequestHandlerAfterCurrent(new IRequestHandler() {
			
			@Override
			public void respond(IRequestCycle requestCycle) {
				requestCycle.getResponse().write(json.render(true));
			}
			
			@Override
			public void detach(IRequestCycle requestCycle) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
