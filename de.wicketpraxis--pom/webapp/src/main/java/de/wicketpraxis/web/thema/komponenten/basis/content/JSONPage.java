/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import org.apache.wicket.markup.html.WebPage;

import com.sdicons.json.mapper.MapperException;

public class JSONPage extends WebPage {

	public JSONPage() throws MapperException {
		DummyBean bean = new DummyBean();
		bean.setName("Klaus");
		bean.setNr(1);

		RenderJSON.onPage(this).with(bean);
	}

	public static class DummyBean {

		int _nr;

		String _name;

		public int getNr() {
			return _nr;
		}

		public void setNr(int nr) {
			_nr = nr;
		}

		public String getName() {
			return _name;
		}

		public void setName(String name) {
			_name = name;
		}
	}
}
