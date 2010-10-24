/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


public interface DaoInterface<K extends Serializable,T extends DoInterface<K>>
{
	void delete(T o);
	
	void save(T o);
	
	void update(T o);
	
	T get(K id);
	
	T getNew();
	
	public List<T> findAll(int offset,int max);
	
	public int countAll();
}

