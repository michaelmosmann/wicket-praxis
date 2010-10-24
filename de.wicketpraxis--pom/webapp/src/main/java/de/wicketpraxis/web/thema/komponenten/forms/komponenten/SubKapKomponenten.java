/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.forms.komponenten;

import java.util.List;

import org.apache.wicket.Page;

import de.wicketpraxis.web.thema.AbstractKapitel;
import de.wicketpraxis.web.thema.TitleAnnotation;
import de.wicketpraxis.web.thema.komponenten.forms.SubKapForms;
import de.wicketpraxis.web.thema.komponenten.forms.ajax.AutoCompleteTextFieldPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.check.CheckBoxPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.check.CheckGroupPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.formcomplabel.FormCompLabelPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.formcomplabel.SimpleFormCompLabelPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.radio.RadioButtonPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.select.DropDownChoicePage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.select.ListMultipleChoicePage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.select.PalettePage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.select.SimpleSelectPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield.FormTextFieldTypePage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield.FormWithTextFieldPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.textfield.TextFieldsPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.upload.FileUploadPage;
import de.wicketpraxis.web.thema.komponenten.forms.komponenten.upload.MultiFileUploadPage;

@TitleAnnotation(title="Formulare - Komponenten")
public class SubKapKomponenten extends AbstractKapitel
{

	@Override
	protected void addPages(List<Class<? extends Page>> pages)
	{
		pages.add(FormTextFieldTypePage.class);
		pages.add(FormWithTextFieldPage.class);
		pages.add(TextFieldsPage.class);
		
		pages.add(SimpleFormCompLabelPage.class);
		pages.add(FormCompLabelPage.class);
		
		pages.add(CheckBoxPage.class);
		pages.add(CheckGroupPage.class);
		
		pages.add(RadioButtonPage.class);
		
		pages.add(SimpleSelectPage.class);
		pages.add(DropDownChoicePage.class);
		pages.add(ListMultipleChoicePage.class);
		pages.add(PalettePage.class);
		
		pages.add(FileUploadPage.class);
		pages.add(MultiFileUploadPage.class);
	}

	@Override
	protected Class<? extends Page> getParentPageClass()
	{
		return SubKapForms.class;
	}

}
