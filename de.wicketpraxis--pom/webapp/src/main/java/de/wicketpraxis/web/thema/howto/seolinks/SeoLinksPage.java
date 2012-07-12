/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.seolinks;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SeoLinksPage extends WebPage {

	public SeoLinksPage(PageParameters pageParameters) {
		// DisabledJSessionIDinUrlFilter
		// RobotJSessionIDUrlFilter

		ConfigBean config = new ConfigBean();
		BeanPagePropertyUtil.setParameter(config, pageParameters);

		add(new Label("Seite", new PropertyModel<Integer>(config, "Seite")));
		add(new Label("Kategorie", new PropertyModel<Integer>(config, "Kategorie")));

		ConfigBean configSeite = config.getClone();
		configSeite.setSeite(1);
		add(new BeanBookmarkablePageLink<SeoLinksPage, ConfigBean>("linkSeite", SeoLinksPage.class, configSeite));
		ConfigBean configKategorie = config.getClone();
		configKategorie.setKategorie("Angebot");
		add(new BeanBookmarkablePageLink<SeoLinksPage, ConfigBean>("linkKategorie", SeoLinksPage.class, configKategorie));

		ConfigBean configClearSeite = config.getClone();
		configClearSeite.setSeite(null);
		add(new BeanBookmarkablePageLink<SeoLinksPage, ConfigBean>("linkClearSeite", SeoLinksPage.class, configClearSeite));
		ConfigBean configClearKategorie = config.getClone();
		configClearKategorie.setKategorie(null);
		add(new BeanBookmarkablePageLink<SeoLinksPage, ConfigBean>("linkClearKategorie", SeoLinksPage.class,
				configClearKategorie));

	}
}
