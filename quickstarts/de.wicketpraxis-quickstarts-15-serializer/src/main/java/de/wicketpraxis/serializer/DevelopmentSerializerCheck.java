package de.wicketpraxis.serializer;

import java.io.IOException;

import org.apache.wicket.util.io.ByteArrayOutputStream;
import org.apache.wicket.util.objects.checker.CheckingObjectOutputStream;
import org.apache.wicket.util.objects.checker.NotDetachedModelChecker;
import org.apache.wicket.util.objects.checker.OrphanComponentChecker;


public class DevelopmentSerializerCheck extends CheckingObjectOutputStream {

	public DevelopmentSerializerCheck() throws IOException {
		super(new ByteArrayOutputStream(),new OrphanComponentChecker(),new NotDetachedModelChecker(), new EntitySerializationNotAllowedChecker());
	}

}
