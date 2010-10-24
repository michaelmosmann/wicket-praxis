package de.wicketpraxis.web.blog.wicketstuff;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.wicketstuff.artwork.liquidcanvas.LiquidCanvasBehavior;
import org.wicketstuff.artwork.liquidcanvas.graphics.Border;
import org.wicketstuff.artwork.liquidcanvas.graphics.Fill;
import org.wicketstuff.artwork.liquidcanvas.graphics.Gradient;
import org.wicketstuff.artwork.liquidcanvas.graphics.RoundedRect;
import org.wicketstuff.artwork.liquidcanvas.graphics.Shadow;
import org.wicketstuff.jwicket.SpecialKeys;
import org.wicketstuff.jwicket.tooltip.WalterZornTips;
import org.wicketstuff.jwicket.ui.dragdrop.DraggableBehavior;
import org.wicketstuff.jwicket.ui.dragdrop.DroppableBehavior;
import org.wicketstuff.scriptaculous.inplaceeditor.AjaxEditInPlaceLabel;

public class StuffPage extends WebPage
{
	public StuffPage()
	{
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);
		
		WebMarkupContainer div = new WebMarkupContainer("div");
		
		div.add(new LiquidCanvasBehavior(new Border("red",1),new RoundedRect((byte) 3),new Gradient("blue","yellow"),new Shadow(3,"#808080",3),new Fill("#606060")));
		
		add(div);
		
		WalterZornTips zw=new WalterZornTips("What");
		zw.setFadein(300);
		div.add(zw);
		div.add(new DraggableBehavior()
		{
			@Override
			protected void onDragStop(AjaxRequestTarget target, SpecialKeys specialKeys)
			{
				target.addComponent(getComponent());
			}
		}.setOpacity(0.5));
		
	
		WebMarkupContainer div2 = new WebMarkupContainer("div2");
		div2.add(new DroppableBehavior()
		{
			@Override
			protected void onDrop(AjaxRequestTarget target, Component draggedComponent, SpecialKeys specialKeys)
			{
				info("Dropped: "+draggedComponent.toString());
				target.addComponent(feedbackPanel);
				target.addComponent(draggedComponent);
			}
			
		});
		add(div2);
		
		add(new AjaxEditInPlaceLabel<String>("editInPlace",Model.of("Klaus")));
		add(new AjaxEditableLabel<String>("editInPlaceCore",Model.of("Klaus")));
	}
}
