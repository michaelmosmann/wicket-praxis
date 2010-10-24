/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.IRequestTarget;
import org.apache.wicket.Page;
import org.apache.wicket.RequestCycle;

import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.mapper.helper.impl.ObjectMapper;
import com.sdicons.json.model.JSONValue;

public class RenderJSON
{
	Page _page;
	
	private RenderJSON(Page page)
	{
		_page=page;
	}
	
	public static RenderJSON onPage(Page page)
	{
		return new RenderJSON(page);
	}
	
	public <T> void with(T bean) throws MapperException
	{
		render(_page,bean);
	}
	
	static <T> void render(Page page, T bean) throws MapperException
	{
		final JSONValue json = new ObjectMapper().toJSON(bean);
		
		page.getRequestCycle().setRequestTarget(new IRequestTarget() {

			public void detach(RequestCycle requestCycle)
			{
				// nothing to do
			}

			public void respond(RequestCycle requestCycle)
			{
				requestCycle.getResponse().write(json.render(true));
			}
		});
	}
}
