package de.wicketpraxis.web.blog.pages.questions.ajax.parameter;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.markup.html.image.resource.DynamicImageResource;
import org.apache.wicket.markup.html.image.resource.RenderedDynamicImageResource;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.protocol.http.WebResponse;
import org.apache.wicket.util.time.Duration;

public class HeatMapPage extends WebPage {

	List<Pos> _points = new ArrayList<Pos>();
	int _xOffset = 0;
	int _yOffset = 0;

	public HeatMapPage() {
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		add(feedbackPanel);

		final WebMarkupContainer box = new WebMarkupContainer("box");
		final ClickMap imageResource = new ClickMap(100, 100);
		final Image image = new NonCachingImage("map", imageResource);
		box.setOutputMarkupId(true);
		box.add(image);
		add(box);

		add(new ElementOffsetBehavior("#content") {

			@Override
			protected void onOffset(AjaxRequestTarget target, int xOffset, int yOffset) {
				info("Offset: " + xOffset + "," + yOffset);
				_xOffset = xOffset;
				_yOffset = yOffset;
				imageResource.invalidate();
				target.addComponent(feedbackPanel);
				target.addComponent(box);
			}
		}.setThrottleDelay(Duration.milliseconds(250)));

		add(new PageMouseClickBehavior("#content") {

			@Override
			protected void onClick(AjaxRequestTarget target, int x, int y) {
				info("Clicked: " + x + "," + y);
				_points.add(new Pos(x, y));
				imageResource.invalidate();
				target.addComponent(box);
				target.addComponent(feedbackPanel);
			}
		}.setThrottleDelay(Duration.milliseconds(50)));

		add(new WindowResizeBehavior() {

			@Override
			protected void onResize(AjaxRequestTarget target, int width, int height) {
				info("Size changed: " + width + "," + height);
				//				image.setImageResource(new ClickMap(width, height));
				imageResource.setWidth(width);
				imageResource.setHeight(height);
				imageResource.invalidate();

				target.addComponent(feedbackPanel);
				target.addComponent(box);
			}
		}.setThrottleDelay(Duration.milliseconds(250)));

	}

	class ClickMap extends RenderedDynamicImageResource {

		public ClickMap(int width, int height) {
			super(width, height, "jpg");
			setCacheable(false);
		}

		@Override
		protected boolean render(Graphics2D graphics) {
			graphics.setBackground(new Color(255, 255, 255));
			graphics.setColor(new Color(0, 0, 0, 50));
			//			graphics.setStroke(new BasicStroke(1.0f));
			graphics.clearRect(0, 0, getWidth(), getHeight());
			//			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			//			graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			for (Pos p : _points) {
				graphics.fillArc(_xOffset + p.getX() - 5, _yOffset + p.getY() - 5, 9, 9, 0, 360);
			}
			return true;
		}
	}

	static class Pos implements Serializable {

		int _x;
		int _y;

		public Pos(int x, int y) {
			super();
			_x = x;
			_y = y;
		}

		public int getX() {
			return _x;
		}

		public int getY() {
			return _y;
		}
	}
}
