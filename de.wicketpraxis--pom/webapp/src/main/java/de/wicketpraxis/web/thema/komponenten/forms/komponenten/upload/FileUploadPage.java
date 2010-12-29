/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten.upload;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadWebRequest;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.util.lang.Bytes;

import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;

@TitleAnnotation(title = "File Upload", space = true)
public class FileUploadPage extends AbstractFormPage {

	public FileUploadPage() {
		final FileUploadField fileUploadField = new FileUploadField("Upload");

		Form<Void> form = new Form<Void>("form") {

			@Override
			protected void onSubmit() {
				FileUpload upload = fileUploadField.getFileUpload();
				if (upload != null) {
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
