/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.res.images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class BufferedImages
{
	public static BufferedImage getRedBorderImage(int width,int height)
	{
		BufferedImage ret=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) ret.getGraphics();
		graphics.setBackground(new Color(255,255,255));
		graphics.setColor(new Color(255,0,0));
		graphics.clearRect(0, 0, width-1, height-1);
		graphics.drawRect(0, 0, width-1, height-1);
		return ret;
	}
	
	// wird in beispielen nicht mehr benutzt..
	public static byte[] getImageAsJPEG(BufferedImage image) throws ImageFormatException, IOException
	{
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
		param.setQuality(0.89f, false);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(image);
		
		return output.toByteArray();
	}
}
