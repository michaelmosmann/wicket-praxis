/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.tree;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class SimpleTreePage extends WebPage {

	public SimpleTreePage() {
		add(new SimpleTreePanel("root").setLeft(
				new SimpleTreePanel(SimpleTreePanel.LEFT).setLeft(new SimpleTreePanel(SimpleTreePanel.LEFT, true)).setRight(
						new SimpleTreePanel(SimpleTreePanel.RIGHT))).setRight(
				new SimpleTreePanel(SimpleTreePanel.RIGHT, true).setRight(new SimpleTreePanel(SimpleTreePanel.RIGHT))));

		final Label label = new Label("tree");
		label.setEscapeModelStrings(false);
		add(label);

		add(new Link("link") {

			@Override
			public void onClick() {
				Visitor visitor = new Visitor();
				SimpleTreePage.this.visitChildren(visitor);
				label.setDefaultModel(Model.of(visitor.getLog()));
			}
		});
	}

	static class Visitor implements IVisitor<Component> {

		StringBuilder _sb = new StringBuilder();

		public Object component(Component component) {
			_sb.append("ID: ");
			boolean hidden = false;
			if (component instanceof SimpleTreePanel) {
				SimpleTreePanel s = (SimpleTreePanel) component;
				if (s.isChangeable()) {
					s.setVisible(!s.isVisible());
					hidden = !s.isVisible();
				}
			}
			if (hidden)
				_sb.append("<strong>");
			_sb.append(component.getId());
			if (hidden)
				_sb.append("</strong>");
			_sb.append(" (").append(component.getPageRelativePath()).append(")<br>");

			return IVisitor.CONTINUE_TRAVERSAL;
		};

		public String getLog() {
			return _sb.toString();
		}
	}
}
