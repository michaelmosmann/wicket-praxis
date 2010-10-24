Wicket.Window.getMarkup = function(idWindow, idClassElement, idCaption, idContent, idTop, idTopLeft, idTopRight, idLeft, idRight, idBottomLeft, idBottomRight, idBottom, idCaptionText, isFrame) {
	var s =
			"<div class=\"wicket-modal\" id=\""+idWindow+"\" style=\"top: 10px; left: 10px; width: 100px;\"><form style='background-color:transparent;padding:0px;margin:0px;border-width:0px;position:static'>"+
			"<div id=\""+idClassElement+"\">"+
				"<div class=\"w_caption\"  id=\""+idCaption+"\">"+
					"<a class=\"w_close\" href=\"#\"></a>"+									
					"<span id=\""+idCaptionText+"\" class=\"w_captionText\"></span>"+
				"</div>"+
				
				"<div class=\"w_top_1\">"+

				"<div class=\"w_topLeft\" id=\""+idTopLeft+"\">"+
				"</div>"+				

				"<div class=\"w_topRight\" id=\""+idTopRight+"\">"+
				"</div>"+

				"<div class=\"w_top\" id='"+idTop+"'>"+									
				"</div>"+

				"</div>"+
								
				"<div class=\"w_left\" id='"+idLeft+"'>"+
					"<div class=\"w_right_1\">"+
						"<div class=\"w_right\" id='"+idRight+"'>"+
							"<div class=\"w_content_1\" onmousedown=\"if (Wicket.Browser.isSafari()) { event.ignore = true; }  else { Wicket.stopEvent(event); } \">"+																			
							
								"<div class=\"w_content_2\">"+
								"<div class=\"w_content_3\">"+
		 							"<div class=\"w_content\">";
				if (isFrame) {
					if (Wicket.Browser.isIELessThan7() || !Wicket.Browser.isIE()) {												
						s+= "<iframe src='\/\/:' frameborder=\"0\" id='"+idContent+"' allowtransparency=\"false\" style=\"height: 200px\">"+
										"</iframe>";
					} else {
						s+= "<iframe src='about:blank' frameborder=\"0\" id='"+idContent+"' allowtransparency=\"false\" style=\"height: 200px\">"+
						"</iframe>";
					}
				} else {
					s+=
										"<div id='"+idContent+"'></div>";
				}
					s+= 						
									"</div>"+
								"</div>"+
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>"+
				"</div>"+


				"<div class=\"w_bottom_1\" id=\""+idBottom+"\">"+					
					
					"<div class=\"w_bottomRight\"  id=\""+idBottomRight+"\">"+
					"</div>"+
					
					"<div class=\"w_bottomLeft\" id=\""+idBottomLeft+"\">"+
					"</div>"+

					"<div class=\"w_bottom\" id=\""+idBottom+"\">"+				
					"</div>"+				


				"</div>"+				


			"</div>"+
		"</form></div>";
		
		return s;
}
