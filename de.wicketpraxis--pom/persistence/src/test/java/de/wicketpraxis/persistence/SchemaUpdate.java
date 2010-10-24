/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaUpdate extends AbstractTest
{
	private static final Logger _logger = LoggerFactory.getLogger(SchemaUpdate.class);
	
	@Override
	protected String[] getConfigLocations()
	{
		return new String[] { "classpath:/de/wicketpraxis/persistence/persistence-schema-update.xml"};
	}
	
	public void testSchemaUpdate()
	{
		_logger.error("Schema Update");
	}
}
