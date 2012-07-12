/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.converter;

import java.text.DateFormat;
import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;

import de.wicketpraxis.web.converter.CustomDateConverter;
import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Date Converter")
public class DateConverterPage extends WebPage {

	public DateConverterPage() {
		Model<Date> model = Model.of(new Date());
		add(new Label("date", model));
		add(new DateLabel("dateFull", model, DateFormat.FULL));
		add(new DateLabel("dateMedium", model, DateFormat.MEDIUM));
		add(new DateLabel("dateShort", model, DateFormat.SHORT));
		add(new DateLabel("dateTime", model, DateFormat.SHORT, DateFormat.LONG));
	}

	static class DateLabel extends Label {

		IConverter _converter;

		public DateLabel(String id, IModel<?> model, int dateFormat) {
			super(id, model);
			_converter = new CustomDateConverter(dateFormat);
		}

		public DateLabel(String id, IModel<?> model, int dateFormat, int timeFormat) {
			super(id, model);
			_converter = new CustomDateConverter(dateFormat, timeFormat);
		}

		@Override
		public <C> IConverter<C> getConverter(Class<C> type) {
			return _converter;
		}
	}
}
