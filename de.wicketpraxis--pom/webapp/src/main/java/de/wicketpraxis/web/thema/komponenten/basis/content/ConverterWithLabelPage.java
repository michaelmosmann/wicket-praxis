/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.content;

import java.awt.Color;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title = "Converter With Label")
public class ConverterWithLabelPage extends WebPage {

	public ConverterWithLabelPage() {
		IModel<Color> colorModel = Model.of(new Color(255, 128, 64));

		add(new Label("standard", colorModel));

		add(new Label("custom", colorModel) {

			@Override
			public <C> IConverter<C> getConverter(Class<C> type) {
				if (type == Color.class) {
					return new ColorConverter();
				}
				return super.getConverter(type);
			}
		});
	}

	static class ColorConverter implements IConverter {

		public Object convertToObject(String value, Locale locale) {
			return null;
		}

		public String convertToString(Object value, Locale locale) {
			Color color = (Color) value;
			return "(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
		}
	}
}
