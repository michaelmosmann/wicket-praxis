/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.upload;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.MultiFileUploadField;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.util.lang.Bytes;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

public class MultiFileUploadPage extends AbstractFormPage {

	public MultiFileUploadPage() {
		final MultiFileUploadField fileUploadField = new MultiFileUploadField("Upload", new CollectionModel<FileUpload>(
				new ArrayList<FileUpload>()), 5);

		Form<Void> form = new Form<Void>("form") {

			@Override
			protected void onSubmit() {
				Collection<FileUpload> uploads = fileUploadField.getModel().getObject();
				for (FileUpload upload : uploads) {
					info(MessageFormat.format("Filename: {0}, Size: {1}, MimeType: {2}", upload.getClientFileName(),
							upload.getSize(), upload.getContentType()));
				}
			}
		};
		form.setMultiPart(true);
		form.setMaxSize(Bytes.megabytes(100));

		/**
		 * in Application
		 * 
		 * @Override
		 *           protected WebRequest newWebRequest(HttpServletRequest servletRequest)
		 *           {
		 *           return new UploadWebRequest(servletRequest);
		 *           }
		 */
		form.add(new UploadProgressBar("progressbar", form));

		form.add(fileUploadField);
		add(form);

	}
}
