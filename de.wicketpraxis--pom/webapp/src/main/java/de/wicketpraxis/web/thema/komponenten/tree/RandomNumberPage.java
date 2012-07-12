/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

public class RandomNumberPage extends WebPage {

	private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	public RandomNumberPage() {
		List<Integer> list = getNumbers();

		for (int i = 0; i < 9; i++) {
			add(new Label("l" + i, Model.of(list.get(i))));
		}

		add(new Link("link") {

			@Override
			public void onClick() {
				VisitLabels visitor = new VisitLabels();
				RandomNumberPage.this.visitChildren(visitor);
			}
		});
		add(new BookmarkablePageLink<RandomNumberPage>("reset", RandomNumberPage.class));

	}

	private List<Integer> getNumbers() {
		List<Integer> list = new ArrayList<Integer>(NUMBERS);
		List<Integer> ret = new ArrayList<Integer>();

		while (!list.isEmpty()) {
			Integer zahl = list.remove((int) (Math.random() * list.size()));
			ret.add(zahl);
		}
		return ret;
	}

	static class VisitLabels implements IVisitor<Component,Void> {

		@Override
		public void component(Component component, IVisit<Void> visit) {
			if (component instanceof Label) {
				Object data = component.getDefaultModelObject();
				if (data instanceof Integer) {
					int val = (Integer) data;
					if ((val % 3) == 0)
						component.setVisible(!component.isVisible());
				}
			}
		};
	}
}
