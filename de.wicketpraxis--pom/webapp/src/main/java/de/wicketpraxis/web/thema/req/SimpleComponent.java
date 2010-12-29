/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.req;

import org.apache.wicket.Component;
import org.apache.wicket.markup.MarkupStream;

public class SimpleComponent extends Component {

	public SimpleComponent(String id) {
		super(id);
	}

	@Override
	protected void onRender(MarkupStream markupStream) {

	}

	@Override
	protected void onAfterRender() {
		// TODO Auto-generated method stub
		super.onAfterRender();
	}

	@Override
	protected void onBeforeRender() {
		// TODO Auto-generated method stub
		super.onBeforeRender();
	}

	@Override
	protected void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}
}
