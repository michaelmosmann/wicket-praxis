/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.modify;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public abstract class ButtonLink<T> extends Border
{
	public enum Type { OK, INFO, CANCEL };
	
	IModel<T> _model=new Model();
	
	public ButtonLink(String id,IModel<T> model,Type type)
	{
		super(id);
		setRenderBodyOnly(true);
		_model=model;
		
		add(CSSPackageResource.getHeaderContribution(ButtonLink.class,"button.css"));
		
		Link<T> link = new Link<T>("link",model)
		{
			@Override
			public void onClick()
			{
				ButtonLink.this.onClick();
			}
		};
		link.add(new AttributeModifier("class",true,Model.of(type.name())));
		link.add(new Image("icon",new ResourceReference(ButtonLink.class,type.name()+".png")));
		link.add(getBodyContainer());
		add(link);
	}
	
	public abstract void onClick();
}
