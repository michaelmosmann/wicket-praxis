package de.wicketpraxis.seoajax;

import java.io.Serializable;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class StateConverter {

	private StateConverter() {
		// no instance
	}

	enum StateParameter {
		Count,
	};

	public static IModel<IState> asModel(PageParameters pageParameters) {
		return new Model<IState>(asState(pageParameters));
	}

	private static State asState(PageParameters pageParameters) {
		int count = pageParameters.get(StateParameter.Count.name()).toInt(0);
		return new State(count);
	}

	public static PageParameters asPageParameters(IState state) {
		return new PageParameters().add(StateParameter.Count.name(), state.getCounter());
	}

	static class State implements IState, Serializable {

		final int _count;

		public State(int count) {
			_count = count;
		}
		
		@Override
		public IState oneUp() {
			return new State(_count + 1);
		}
		
		@Override
		public IState oneDown() {
			return new State(_count - 1);
		}

		@Override
		public int getCounter() {
			return _count;
		}
	}
}
