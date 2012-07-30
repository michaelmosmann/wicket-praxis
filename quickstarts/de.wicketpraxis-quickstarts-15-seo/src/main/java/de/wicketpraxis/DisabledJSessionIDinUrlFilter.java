/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class DisabledJSessionIDinUrlFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// JSessionID URL encoding ausschalten
		HttpServletResponse wrappedResponse = wrapResponse(httpRequest, httpResponse);

		chain.doFilter(request, wrappedResponse);
	}

	protected HttpServletResponse wrapResponse(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {

			@Override
			public String encodeRedirectUrl(final String url) {
				return url;
			}

			@Override
			public String encodeRedirectURL(final String url) {
				return url;
			}

			@Override
			public String encodeUrl(final String url) {
				return url;
			}

			@Override
			public String encodeURL(final String url) {
				return url;
			}
		};
		return wrappedResponse;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}
}
