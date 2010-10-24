Callback = {
	create: function(oldCallback,newCallback)
	{
		return function(a,b,c,d,e,f)
		{
			if (oldCallback) 
			{
				oldCallback(a,b,c,d,e,f);
			}
			newCallback(a,b,c,d,e,f);
		}
	},
};
