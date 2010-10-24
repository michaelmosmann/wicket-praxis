// aus der Datei modal.js zur Klasse ModalWindow

if (typeof(Wicket.Window) == "undefined") {
	Wicket.Window = { };
}

/**
 * Returns the height of visible area.
 */
Wicket.Window.getViewportHeight = function() {
	if (window.innerHeight != window.undefined) 
		return window.innerHeight;
	
	if (document.compatMode == 'CSS1Compat') 
		return document.documentElement.clientHeight;
		
	if (document.body) 
		return document.body.clientHeight;
		 
	return window.undefined; 
}

/**
 * Returns the width of visible area.
 */
Wicket.Window.getViewportWidth =  function() {
	if (window.innerWidth != window.undefined) 
		return window.innerWidth;
		 
	if (document.compatMode == 'CSS1Compat') 
		return document.documentElement.clientWidth; 
		
	if (document.body) 
		return document.body.clientWidth;
		 
	return window.undefined;
}

/**
 * Returns the horizontal scroll offset
 */
Wicket.Window.getScrollX = function() {
	var iebody = (document.compatMode && document.compatMode != "BackCompat") ? document.documentElement : document.body	
	return document.all? iebody.scrollLeft : pageXOffset
}

/**
 * Returns the vertical scroll offset
 */
Wicket.Window.getScrollY = function() {
	var iebody = (document.compatMode && document.compatMode != "BackCompat") ? document.documentElement : document.body	
	return document.all? iebody.scrollTop : pageYOffset
}


/**
 * Returns element offset
 */
Wicket.Window.getXYOffset = function(obj)
{
	var curleft = 0;
	var curtop = 0;
	if (obj.offsetParent)
	{
		while (obj.offsetParent)
		{
			curleft += obj.offsetLeft;
			curtop += obj.offsetTop;
			obj = obj.offsetParent;
		}
	}
	else
	{
		if (obj.x)
		{
			curleft += obj.x;
		}
		if (obj.y)
		{
			curtop += obj.y;
		}
	}
	
	if (Wicket.Browser.isIE())
	{
		bodyElement=document.getElementsByTagName('body')[0];
		// In IE there's a default margin in the page body. If margin's not defined,
		// use defaults
		var marginLeftExplorer  = parseInt(bodyElement.style.marginLeft);
		var marginTopExplorer   = parseInt(bodyElement.style.marginTop);
		/* assume default 10px/15px margin in explorer */
		if (isNaN(marginLeftExplorer)) {marginLeftExplorer=10;}
		if (isNaN(marginTopExplorer)) {marginTopExplorer=15;}
		curleft=curleft+marginLeftExplorer;
		curtop=curtop+marginTopExplorer;
	}

	return [curleft,curtop];
}
