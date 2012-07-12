/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.debug.unittests;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.ITestPanelSource;
import org.apache.wicket.util.tester.WicketTester;

public class TestCustomPanel {

	public void testPage() {
		WicketTester tester = new WicketTester();
		tester.startPage(UnitTestPage.class);
		tester.clickLink("mypanel:link", false);
		tester.assertInfoMessages(new String[] {"Link ohne Ajax"});
	}

	public void testPanel() {
		WicketTester tester = new WicketTester();
		tester.startPanel(new ITestPanelSource() {

			public Panel getTestPanel(String panelId) {
				return new CustomPanel(panelId);
			}
		});
		tester.clickLink("panel:link");
		tester.assertComponentOnAjaxResponse("panel:feedback");
		tester.assertInfoMessages(new String[] {"Link per Ajax"});
	}
}
