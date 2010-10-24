/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class AbstractTest extends AbstractTransactionalDataSourceSpringContextTests
{
	@Override
	protected String[] getConfigLocations()
	{
		return new String[] { "classpath:/de/wicketpraxis/persistence/persistence-test.xml"};
	}
	
	protected <T> T getBean(String name,Class<T> requiredType)
	{
		return (T) getApplicationContext().getBean(name, requiredType);
	}
	
	protected <T> T getBean(Class<T> requiredType)
	{
		Map beansOfType = getApplicationContext().getBeansOfType(requiredType);
		if (beansOfType.size()==1)
		{
			return (T) new ArrayList(beansOfType.values()).get(0);
		}
		return null;
	}
}
