package de.wicketpraxis.usecase.finals;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class FinalsV1Page extends WebPage
{
	public FinalsV1Page()
	{
		final Irrelevant irrelevantToLabel=new Irrelevant();
		
		add(new Label("label", "Fun"){
			
			@Override
			protected void onInitialize()
			{
				super.onInitialize();
				if (false) {
					setDefaultModelObject(irrelevantToLabel.text);
				}
			}
		});
		setStatelessHint(false);
	}
	
	static class Irrelevant implements Serializable {
		String text="this could be something big.";
		byte[] veryBig=new byte[1024];
	}
}
