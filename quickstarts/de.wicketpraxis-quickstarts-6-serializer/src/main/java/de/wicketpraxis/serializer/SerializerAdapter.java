package de.wicketpraxis.serializer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.serialize.ISerializer;
import org.apache.wicket.serialize.java.DeflatedJavaSerializer;
import org.apache.wicket.serialize.java.JavaSerializer;
import org.apache.wicket.util.lang.Bytes;
import org.wicketstuff.pageserializer.fast.FastWicketSerializer;
import org.wicketstuff.pageserializer.kryo2.KryoSerializer;

public class SerializerAdapter implements ISerializer {

	private final JavaSerializer javaSerializer;
	private final List<ISerializer> altSerializer;

	public SerializerAdapter(final String applicationKey) {
		javaSerializer = new JavaSerializer(applicationKey);
		
		List<ISerializer> serializer=new ArrayList<ISerializer>();
		serializer.add(new DeflatedJavaSerializer(applicationKey));
		serializer.add(new KryoSerializer(Bytes.megabytes(10)));
		serializer.add(new FastWicketSerializer(Bytes.megabytes(10)));
		altSerializer=serializer;
	}

	@Override
	public byte[] serialize(Object object) {
		Map<Class<? extends ISerializer>, TimedSerializeResult> results=new LinkedHashMap<Class<? extends ISerializer>, TimedSerializeResult>();
		TimedSerializeResult defaultResult = serialize(javaSerializer,object);
		results.put(javaSerializer.getClass(), defaultResult);
		
		for (ISerializer serializer : altSerializer) {
			TimedSerializeResult result = serialize(serializer,object);
			results.put(serializer.getClass(), result);
		}
		
		printReport(object.getClass(), results);
		
		return defaultResult.result();
	}

	private void printReport(Class<?> serializedType, Map<Class<? extends ISerializer>, TimedSerializeResult> results) {
		System.out.println("--------------------------------");
		System.out.println("->"+serializedType);
		for (Class<? extends ISerializer> implementation : results.keySet()) {
			TimedSerializeResult result = results.get(implementation);
			System.out.println(""+implementation+": "+result.timeSpend()+"ms for "+result.result().length+"bytes");
		}
	}

	@Override
	public Object deserialize(byte[] data) {
		return javaSerializer.deserialize(data);
	}

	static TimedSerializeResult serialize(ISerializer serializer, Object object) {
		long start=System.currentTimeMillis();
		byte[] result = serializer.serialize(object);
		return new TimedSerializeResult(result,System.currentTimeMillis()-start);
	}
	
	static class TimedSerializeResult {

		private final byte[] _result;
		private final long _timeSpend;

		public TimedSerializeResult(byte[] result, long timeSpend) {
			_result = result;
			_timeSpend = timeSpend;
		}

		public byte[] result() {
			return _result;
		}
		
		public long timeSpend() {
			return _timeSpend;
		}
	}
}
