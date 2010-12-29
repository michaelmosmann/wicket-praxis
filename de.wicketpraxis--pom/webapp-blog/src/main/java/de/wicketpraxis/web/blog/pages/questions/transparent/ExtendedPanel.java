package de.wicketpraxis.web.blog.pages.questions.transparent;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converters.DateConverter;

public class ExtendedPanel extends AbstractBasePanel {

	public ExtendedPanel(String id) {
		super(id);

		IModel<Date> model = new LoadableDetachableModel<Date>() {

			protected Date load() {
				return new Date();
			};
		};

		add(new Label("date", model) {

			@Override
			public IConverter getConverter(Class<?> type) {
				return new DateConverter() {

					public DateFormat getDateFormat(Locale locale) {
						if (locale == null) {
							locale = Locale.getDefault();
						}

						return DateFormat.getTimeInstance(DateFormat.LONG, locale);
					}
				};
			}
		});

		add(new DummyPanel("dummy"));
	}
}
