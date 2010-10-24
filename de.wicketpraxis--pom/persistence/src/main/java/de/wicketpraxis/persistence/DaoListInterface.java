/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import java.util.List;

public interface DaoListInterface<R>
{
	public List<R> getList(Integer offset,Integer max);
}
