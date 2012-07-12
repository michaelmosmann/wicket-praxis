/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.panels;

import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;

public abstract class AbstractVisibleBorder<T> extends Border {

	public AbstractVisibleBorder(String id, IModel<T> model) {
		super(id, model);
	}

	public AbstractVisibleBorder<T> getInvers(String id) {
		final AbstractVisibleBorder<T> _this = this;

		return new AbstractVisibleBorder<T>(id, (IModel<T>) getDefaultModel()) {

			protected boolean isVisibleWith(T object) {
				return !_this.isVisibleWith(object);
			};
		};
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();
		IModel<T> model = (IModel<T>) getDefaultModel();

		setVisible(isVisibleWith(model.getObject()));
	}

	protected abstract boolean isVisibleWith(T object);
}
