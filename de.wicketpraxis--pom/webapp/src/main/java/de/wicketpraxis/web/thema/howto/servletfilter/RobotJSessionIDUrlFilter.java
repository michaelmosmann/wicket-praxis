/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.servletfilter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RobotJSessionIDUrlFilter extends DisabledJSessionIDinUrlFilter
{
	private static final String USER_AGENT_HEADER_NAME = "User-Agent";
	
	private static final String[] _botAgents =
	{
		"googlebot", "slurp",
  };
	
	private static final String[] _noBotAgents =
	{
		"firefox","msie","opera","netscape","safari",
	};
	
	private static final Set<String> _botAgentsSet=new HashSet<String>();
	private static final Set<String> _noBotAgentsSet=new HashSet<String>();
	static
	{
		for (String s : _botAgents)
		{
			_botAgentsSet.add(s);
		}
		for (String s : _noBotAgents)
		{
			_noBotAgentsSet.add(s);
		}
	}
	
	@Override
	protected HttpServletResponse wrapResponse(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
	{
		if (isRobot(httpRequest))
		{
			return super.wrapResponse(httpRequest, httpResponse);
		}
		return httpResponse;
	}

	private boolean isRobot(HttpServletRequest httpRequest)
  {
		String userAgent=httpRequest.getHeader(USER_AGENT_HEADER_NAME);
		return isRobot(userAgent);
  }

	public static boolean isRobot(String userAgent)
  {
	  if (userAgent!=null)
		{
			String userAgentLowerCase=userAgent.toLowerCase();
			for (String s : _noBotAgentsSet)
			{
				if (userAgentLowerCase.indexOf(s)>-1)
				{
					return false;
				}
			}
			for (String s : _botAgentsSet)
			{
				if (userAgentLowerCase.indexOf(s)>-1)
				{
					return true;
				}
			}
		}
	  return false;
  }

}
