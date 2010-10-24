/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.apps.example.components.navigation.model;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.web.model.Cascading2LoadableDetachableModel;

public class ConditionalPassModel<T> extends Cascading2LoadableDetachableModel<T, Boolean, T>
{
	private static final Logger _logger = LoggerFactory.getLogger(ConditionalPassModel.class);
	
	public ConditionalPassModel(IModel<? extends Boolean> modelParent1, IModel<? extends T> parent2)
	{
		super(modelParent1, parent2);
	}

	protected T load(Boolean p1, T p2)
	{
//		_logger.error("Check: {}, Model: {}",p1,p2);
		if (p1.booleanValue())
		{
			return p2;
		}
		return null;
	};
	
	public static <T> IModel<T> getModel(IModel<? extends Boolean> check,IModel<T> pass)
	{
		return new ConditionalPassModel<T>(check,pass);
	}
}
