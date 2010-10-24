/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.thema.howto.css.styles.header;

import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;

public class IEConditionalHeader
{
  public static final IHeaderContributor START=new IHeaderContributor()
  {
		public void renderHead(IHeaderResponse response)
    {
      response.renderString("<!--[if IE]>");
    }
  };
  public static final IHeaderContributor END=new IHeaderContributor()
  {
		public void renderHead(IHeaderResponse response)
    {
      response.renderString("<![endif]-->");
    }
  };
}
