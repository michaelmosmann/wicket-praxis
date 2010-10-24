package de.wicketpraxis.web.blog.pages.questions.factories;

import org.apache.wicket.Component;

public interface IComponentFactory<T extends Component>
{
	T newComponent(String id);
}
