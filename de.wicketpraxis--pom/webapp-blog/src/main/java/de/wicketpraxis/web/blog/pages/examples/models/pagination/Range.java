package de.wicketpraxis.web.blog.pages.examples.models.pagination;

public class Range<T> {

	final long _start;
	final long _end;

	public Range(long start, long end) {
		_start = start;
		_end = end;
		if (_start>_end)	throw new IllegalArgumentException("Range invalid: "+_start+":"+_end);
	}

	public long getStart() {
		return _start;
	}

	public long getEnd() {
		return _end;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (_end ^ (_end >>> 32));
		result = prime * result + (int) (_start ^ (_start >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (_end != other._end)
			return false;
		if (_start != other._start)
			return false;
		return true;
	}
}
