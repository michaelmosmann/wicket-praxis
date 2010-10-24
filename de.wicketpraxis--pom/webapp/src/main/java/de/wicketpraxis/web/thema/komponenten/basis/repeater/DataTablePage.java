/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.komponenten.basis.repeater;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.Model;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(title="DataTable")
public class DataTablePage extends WebPage
{
	public DataTablePage()
	{
		List<Kunde> liste=new ArrayList<Kunde>();
		for (int i=1;i<7;i++)
		{
			liste.add(new Kunde("Hansi","Klapper der "+i+".",1381+i*69));
		}

		IDataProvider<Kunde> data=new ListDataProvider<Kunde>(liste);
		IColumn[] columns=
		{
				new PropertyColumn<Kunde>(Model.of("Vorname"),"vorname"),
				new PropertyColumn<Kunde>(Model.of("Name"),"name"),
				new PropertyColumn<Kunde>(Model.of("J"),"geburtsjahr"),
		};
		
		DataTable<Kunde> dataTable = new DataTable<Kunde>("list",columns,data,3);
		dataTable.addTopToolbar(new NavigationToolbar(dataTable));
		add(dataTable);
	}
}
