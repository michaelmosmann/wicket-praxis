/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;

import org.apache.wicket.Resource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.resource.BufferedDynamicImageResource;
import org.apache.wicket.markup.html.image.resource.RenderedDynamicImageResource;
import org.apache.wicket.markup.html.link.ResourceLink;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(space=true,title="DynamicImage")
public class DynamicImagePage extends WebPage
{
	public DynamicImagePage()
	{
		BufferedDynamicImageResource imageResource=new BufferedDynamicImageResource("jpeg");
		imageResource.setImage(BufferedImages.getRedBorderImage(100, 100));
		
		RenderedDynamicImageResource renderedResource=new RenderedDynamicImageResource(200,50)
		{
			@Override
			protected boolean render(Graphics2D graphics)
			{
				graphics.setBackground(new Color(200,200,200));
				graphics.setColor(new Color(255,255,255));
				graphics.clearRect(0, 0, getWidth(), getHeight());
				graphics.drawString(new Date().toString(), 2, 20);
				return true;
			}
		};
		
		add(new Image("image",imageResource));
		add(new Image("image2",renderedResource));
		
		add(new ResourceLink<Resource>("imageLink",imageResource));
	}
}
