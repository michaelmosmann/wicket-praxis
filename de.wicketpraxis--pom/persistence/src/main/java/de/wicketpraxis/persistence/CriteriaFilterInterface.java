/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import org.hibernate.Criteria;

public interface CriteriaFilterInterface
{
	public void applyFilter(Criteria criteria);
}
