package de.wicketpraxis.web.blog.pages.questions.email;

import java.util.logging.Logger;

public class WicketThreadAdapter<I, O> extends Thread {

	private static final Logger _logger = Logger.getLogger(WicketThreadAdapter.class.getName());

	Object _lock = new Object();

	WicketCallback<I, O> _callback;
	I _input;
	O _output;
	boolean _done = false;

	protected WicketThreadAdapter(WicketCallback<I, O> callback, I input) {
		_callback = callback;
		_input = input;
	}

	@Override
	public void run() {
		synchronized (_lock) {
			_output = _callback.getResult(_input);
			_done = true;
			_lock.notify();
		}
	}

	protected O getResult() throws InterruptedException {
		synchronized (_lock) {
			while (!_done) {
				_lock.wait();
			}
			return _output;
		}
	}

	public static <I, O> O getResult(WicketCallback<I, O> callback, I input) throws InterruptedException {
		WicketThreadAdapter<I, O> threadAdapter = new WicketThreadAdapter<I, O>(callback, input);
		threadAdapter.start();
		return threadAdapter.getResult();
	}
}
