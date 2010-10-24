/**
 * Click Listener derived from http://blog.corunet.com/the-definitive-heatmap/
 * 
 */
PageMouseClickBehavoir = 
{
	init: function(callback,contentId)
	{
		function Listener(callback,contentId)
		{
			this.xOffset=0;
			this.yOffset=0;
			this.firstElement=null;
	
			// function(x,y)
			this.onMouseEvent=callback;
			
			this.mouseEvent= function(e)
			{
				tempX=0;
				tempY=0;
				
				if (Wicket.Browser.isIE() || Wicket.Browser.isGecko())
				{
					tempX = e.clientX + Wicket.Window.getScrollX();
					tempY = e.clientY + Wicket.Window.getScrollY();
				}
				else
				{
					tempX = e.pageX
					tempY = e.pageY
				}
				tempX-=this.xOffset;
				tempY-=this.yOffset;
				this.onMouseEvent(tempX,tempY);
				return true;
			};
			
			this.updateOffsets=function()
			{
				var offsets=Wicket.Window.getXYOffset(this.firstElement);
				this.xOffset=offsets[0];
				this.yOffset=offsets[1];
			};
			
			var bodyElement=document.getElementsByTagName('body')[0];
			this.firstElement=bodyElement.childNodes[1];
			if (contentId!=null)
			{
				this.firstElement=document.getElementById(contentId);
			}
			
			this.updateOffsets();
		}
	
	
		var listener=new Listener(callback,contentId);
		
		document.onmousedown=Callback.create(document.onmousedown,function(e)
		{
			listener.mouseEvent(e)
		});
		window.onresize=Callback.create(window.onresize,function()
		{
			listener.updateOffsets();
		});
	},
}

