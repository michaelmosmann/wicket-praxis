/**
 * Click Listener derived from http://blog.corunet.com/the-definitive-heatmap/
 * 
 */
ElementOffsetBehavoir =
{
	init : function(callback, contentId)
	{
		function Listener(callback, contentId)
		{
			this.xOffset = 0;
			this.yOffset = 0;
			this.firstElement = null;

			// function(xOffset,yOffset)
			this.onOffsetChanged = callback;

			this.updateOffsets = function()
			{
				var offsets = Wicket.Window.getXYOffset(this.firstElement);
				this.xOffset = offsets[0];
				this.yOffset = offsets[1];
				this.onOffsetChanged(this.xOffset, this.yOffset);
			};

			var bodyElement = document.getElementsByTagName('body')[0];
			this.firstElement = bodyElement.childNodes[1];
			if (contentId != null)
			{
				this.firstElement = document.getElementById(contentId);
			}
		}

		var listener = new Listener(callback, contentId);
		listener.updateOffsets();
		window.onresize = Callback.create(window.onresize, function()
		{
			listener.updateOffsets();
		});
	}
}
