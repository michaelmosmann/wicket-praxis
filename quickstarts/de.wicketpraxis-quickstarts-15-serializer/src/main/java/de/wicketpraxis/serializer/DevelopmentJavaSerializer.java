package de.wicketpraxis.serializer;

import java.io.IOException;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.serialize.java.JavaSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevelopmentJavaSerializer extends JavaSerializer {

	private static final Logger log = LoggerFactory.getLogger(DevelopmentJavaSerializer.class);

	public DevelopmentJavaSerializer(String applicationKey) {
		super(applicationKey);
	}

	@Override
	public byte[] serialize(Object object) {

		try {
			new DevelopmentSerializerCheck().writeObject(object);
			
			return super.serialize(object);
		} catch (IOException e) {
			log.error("error writing object " + object + ": " + e.getMessage(), e);
			throw new WicketRuntimeException(e);
		}

	}

}
