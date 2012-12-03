package de.wicketpraxis.serializer;

import org.apache.wicket.util.objects.checker.AbstractObjectChecker;

public class EntitySerializationNotAllowedChecker extends AbstractObjectChecker {

	@Override
	protected Result doCheck(Object object) {
		if (object instanceof IEntity)
			return new Result(Result.Status.FAILURE, "entity serialization not allowed");
		return Result.SUCCESS;
	}

}
