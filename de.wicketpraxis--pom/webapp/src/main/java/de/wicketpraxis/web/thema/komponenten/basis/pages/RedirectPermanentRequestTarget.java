/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.pages;

import javax.servlet.http.HttpServletResponse;

import org.apache.wicket.IRequestTarget;
import org.apache.wicket.RequestContext;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Response;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.protocol.http.portlet.PortletRequestContext;

public class RedirectPermanentRequestTarget implements IRequestTarget
{
	String _redirectUrl;
	
	public RedirectPermanentRequestTarget(String url)
	{
		_redirectUrl=url;
	}
	
	public void respond(RequestCycle requestCycle)
	{
		WebResponse response = (WebResponse) requestCycle.getResponse();
		response.reset();
		if (_redirectUrl.startsWith("/"))
		{
			// context-absolute url

			RequestContext rc = RequestContext.get();
			if (rc.isPortletRequest() && ((PortletRequestContext)rc).isEmbedded())
			{
				redirect(response, _redirectUrl);
			}
			else
			{
				String location = RequestCycle.get()
					.getProcessor()
					.getRequestCodingStrategy()
					.rewriteStaticRelativeUrl(_redirectUrl.substring(1));
				if (location.startsWith("./") && location.length() > 2)
				{
					location = location.substring(2);
				}
				redirect(response, location);
			}
		}
		else if (_redirectUrl.contains("://"))
		{
			// absolute url
			redirect(response, _redirectUrl);
		}
		else
		{
			// relative url
			redirect(response,RequestCycle.get()
				.getRequest()
				.getRelativePathPrefixToWicketHandler() +
				_redirectUrl);
		}
	}

	private void redirect(WebResponse response, String toUrl)
	{
//		response.redirect(toUrl);
		response.setHeader("Location", response.encodeURL(toUrl).toString());
		response.getHttpServletResponse().setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	}

	public void detach(RequestCycle requestCycle)
	{
	}

}
