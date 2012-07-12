/*****************************************
 * Quelltexte zum Buch: Praxisbuch Wicket
 * (http://www.hanser.de/978-3-446-41909-4)
 * 
 * Autor: Michael Mosmann
 * (michael@mosmann.de)
 *****************************************/
package de.wicketpraxis.web.thema.howto.optimize;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.javascript.DefaultJavaScriptCompressor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IApplicationSettings;
import org.apache.wicket.settings.IDebugSettings;
import org.apache.wicket.settings.IMarkupSettings;
import org.apache.wicket.settings.IPageSettings;
import org.apache.wicket.settings.IRequestLoggerSettings;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.settings.ISecuritySettings;
import org.apache.wicket.util.lang.Bytes;

import de.wicketpraxis.web.thema.TitleAnnotation;

@TitleAnnotation(space = true, title = "Optimize Application Settings")
public class OptimizePage extends WebPage {

	/*
	 * Code in Application
	 */
	public static void init(WebApplication _this) {
		if (false) {
			// Application Settings
			IApplicationSettings applicationSettings = _this.getApplicationSettings();

			// pages
			applicationSettings.setAccessDeniedPage(Page.class);
			applicationSettings.setInternalErrorPage(Page.class);
			applicationSettings.setPageExpiredErrorPage(Page.class);

			applicationSettings.setDefaultMaximumUploadSize(Bytes.megabytes(12));

			// App Configuration
			RuntimeConfigurationType configurationType = _this.getConfigurationType();
			if (configurationType==RuntimeConfigurationType.DEVELOPMENT) {
				// fallback
			}
			if (configurationType==RuntimeConfigurationType.DEPLOYMENT) {

			}

			// Converter Locator - überschreiben und weiterreichen
			_this.getConverterLocator();

			IDebugSettings debugSettings = _this.getDebugSettings();
			debugSettings.setAjaxDebugModeEnabled(true); // default in DEV
			debugSettings.setComponentUseCheck(true); // default in DEV
			debugSettings.setDevelopmentUtilitiesEnabled(true); // default in DEV

			// use with care
			debugSettings.setLinePreciseReportingOnAddComponentEnabled(false);
			debugSettings.setLinePreciseReportingOnNewComponentEnabled(false);

			// usefull for debugging - fills wicket:path attr in tag
			debugSettings.setOutputComponentPath(false);
			// sehr hilfreich, um zu sehen, von welcher komponente 
			// welcher inhalt dargestellt wird - see kap debugging
			debugSettings.setOutputMarkupContainerClassName(false);

			// unterschiedliche einstellungen in DEV und DEPLOYMENT
			IMarkupSettings markupSettings = _this.getMarkupSettings();
			// entfernt whitespaces aus markups - könnte was kaputt machen
			// wenn man halbwegs kompakte markups schreibt, ist das wohl kein gewinn
			// im vergleich zum risiko
			markupSettings.setCompressWhitespace(false);
			// wenn ein Link mit setEnable(false) deaktiviert wurde, wird
			// das eingefügt .. hmm
			markupSettings.setDefaultBeforeDisabledLink("<i>");
			markupSettings.setDefaultAfterDisabledLink("</i>");

			// ??
			markupSettings.setAutomaticLinking(false);

			IPageSettings pageSettings = _this.getPageSettings();

			IRequestLoggerSettings requestLoggerSettings = _this.getRequestLoggerSettings();
			requestLoggerSettings.setRequestLoggerEnabled(false);
			/**
			 * 21.05.2009 08:44:21 org.apache.wicket.protocol.http.RequestLogger log
			 * INFO: time=162,event=BookmarkablePage[de.wicketpraxis.web.thema.howto.KapHowto()],response=BookmarkablePage[de.
			 * wicketpraxis
			 * .web.thema.howto.KapHowto()],sessionid=null,sessionsize=1794,activerequests=0,maxmem=265M,total=25M,used=18M
			 */

			IResourceSettings resourceSettings = _this.getResourceSettings();
//			resourceSettings.setAddLastModifiedTimeToResourceReferenceUrl(false);
//			resourceSettings.setDisableGZipCompression(false);
			// kann evtl. zu problemen führen, wenn die js-lib nicht sauber ist..
			resourceSettings.setJavaScriptCompressor(new DefaultJavaScriptCompressor());
			resourceSettings.setThrowExceptionOnMissingResource(false);

			ISecuritySettings securitySettings = _this.getSecuritySettings();
			// zugriff auf wicket:bookmarkablePage nicht mehr erlaubt, wenn true
			securitySettings.setEnforceMounts(false);
		}
	}
	/*
	 * Code in Application
	 */

}
