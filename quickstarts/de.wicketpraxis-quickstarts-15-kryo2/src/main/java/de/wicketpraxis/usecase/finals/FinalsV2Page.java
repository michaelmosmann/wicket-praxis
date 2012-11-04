package de.wicketpraxis.usecase.finals;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class FinalsV2Page extends WebPage
{
	public FinalsV2Page()
	{
		//final Irrelevant irrelevantToLabel=new Irrelevant();
		
		add(new Label("label", "Fun"){
			
			@Override
			protected void onInitialize()
			{
				super.onInitialize();
				if (false) {
					setDefaultModelObject("this could be something big.");
				}
			}
		});
		setStatelessHint(false);
	}
	
	static class Irrelevant implements Serializable {
		String text="this could be something big.";
	}
}
