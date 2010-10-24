/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.trackingcode;

import java.util.HashMap;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupElement;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.interpolator.MapVariableInterpolator;

public abstract class AbstractGoogleAnalyticsPanel extends Panel
{
	public AbstractGoogleAnalyticsPanel(String id)
	{
		super(id);
		
		add(new WebMarkupContainer("javascript")
		{
			@Override
			protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag)
			{		
				MarkupElement element=markupStream.get();
				String streamAsString=element.toString();
				
//				_logger.severe("Code: "+streamAsString);
				
				HashMap<String, String> parameter = new HashMap<String, String>();
				parameter.put("Code", getAnalyticsCode());
				String virtualPath = getVirtualPath();
				if (virtualPath==null) virtualPath="";
				else
				{
					virtualPath="\""+virtualPath+"\"";
				}
				parameter.put("Path", virtualPath);
				MapVariableInterpolator newContent=new MapVariableInterpolator(streamAsString, parameter);
				replaceComponentTagBody(markupStream, openTag, newContent.toString());
			}
			
		});
	}
	
	@Override
	protected void onBeforeRender()
	{
		super.onBeforeRender();
		getPage().visitChildren(ExternalLink.class, new IVisitor<ExternalLink>()
		{
			public Object component(ExternalLink link)
			{
				String url = link.getDefaultModelObjectAsString();
				if (url.startsWith("http://"))
				{
					url=url.substring("http://".length());
					link.add(new AttributeModifier("onclick",true,new Model<String>("javascript:urchinTracker('/outbound/"+url+"');")));
				}
				return IVisitor.CONTINUE_TRAVERSAL_BUT_DONT_GO_DEEPER;
			}
		});
	}

	/**
	 * Returns Analytics Code
	 * @return UA-xxxx-x Code
	 */
	public abstract String getAnalyticsCode();
	
	/**
	 * Returns VirtualPath if any
	 * @return
	 */
	public abstract String getVirtualPath();
	
}
