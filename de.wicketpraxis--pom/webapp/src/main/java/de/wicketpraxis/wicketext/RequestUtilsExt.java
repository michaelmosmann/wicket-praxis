package de.wicketpraxis.wicketext;

import org.apache.wicket.protocol.http.RequestUtils;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.cycle.RequestCycle;

public class RequestUtilsExt {

	public static String toAbsolutePath(String url) {
		return RequestCycle.get().getUrlRenderer().renderFullUrl(Url.parse(url));
	}

}
