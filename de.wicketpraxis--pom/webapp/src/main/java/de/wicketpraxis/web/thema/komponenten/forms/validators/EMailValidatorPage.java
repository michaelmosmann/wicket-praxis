/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.validators;

import org.apache.wicket.extensions.validation.validator.RfcCompliantEmailAddressValidator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import de.wicketpraxis.web.thema.komponenten.forms.AbstractFormPage;
import de.wicketpraxis.web.thema.komponenten.forms.beans.LoginBean;

public class EMailValidatorPage extends AbstractFormPage {

	public EMailValidatorPage() {
		Form<LoginBean> form = new Form<LoginBean>("form", new CompoundPropertyModel<LoginBean>(new LoginBean())) {

			@Override
			protected void onSubmit() {
				info("EMail: " + getModelObject().getEMail());
			}
		};

		TextField<String> emailTextField = new TextField<String>("EMail");
		boolean needRfcEmail = false;
		if (needRfcEmail) {
			emailTextField.add(RfcCompliantEmailAddressValidator.getInstance());
		} else {
			emailTextField.add(EmailAddressValidator.getInstance());
		}
		form.add(emailTextField);

		add(form);
	}
}
