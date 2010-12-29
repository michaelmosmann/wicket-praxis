package de.wicketpraxis.web.blog.pages.questions.factories;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class TwoInARowFactory implements IComponentFactory<Component> {

	private final IComponentFactory<? extends Component> _left;
	private final IComponentFactory<? extends Component> _right;

	public TwoInARowFactory(IComponentFactory<? extends Component> left, IComponentFactory<? extends Component> right) {
		_left = left;
		_right = right;
	}

	public Component newComponent(String id) {
		return new ContainerPanel(id, _left, _right);
	}

	static class ContainerPanel extends Panel {

		public ContainerPanel(String id, IComponentFactory<? extends Component> left,
				IComponentFactory<? extends Component> right) {
			super(id);

			add(left.newComponent("left"));
			add(right.newComponent("right"));
		}
	}
}
