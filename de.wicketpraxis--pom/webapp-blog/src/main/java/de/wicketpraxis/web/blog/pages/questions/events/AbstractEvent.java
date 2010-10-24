package de.wicketpraxis.web.blog.pages.questions.events;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.Component.IVisitor;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class AbstractEvent
{
	private final Component _source;
	protected final AjaxRequestTarget _target;
	
	public AbstractEvent(final Component source, AjaxRequestTarget target)
	{
		_source = source;
		_target = target;
	}
	
	public AbstractEvent(final Component source)
	{
		this(source,null);
	}
	
	public Component getSource()
	{
		return _source;
	}
	
	/**
	 * notify Application, Session, Page and Components
	 */
	public final void fire()
	{
		Page page=getSource().getPage();
		
		Application application=page.getApplication();
		if (application instanceof EventListenerInterface)
		{
			((EventListenerInterface) application).notifyEvent(this);
		}
		Session session=page.getSession();
		if (session instanceof EventListenerInterface)
		{
			((EventListenerInterface) session).notifyEvent(this);
		}
		if (page instanceof EventListenerInterface)
		{
			((EventListenerInterface) page).notifyEvent(this);
		}
		page.visitChildren(EventListenerInterface.class, getVisitor());
		onAfterFire();
	}

	protected  void onAfterFire()
  {
	  
  }

	protected IVisitor<Component> getVisitor()
  {
	  return new NotifyVisitor(this);
  }

	public AjaxRequestTarget getTarget()
  {
  	return _target;
  }
	
	public boolean isAjax()
	{
		return _target!=null;
	}

	public final void update(Component component)
  {
  	if (_target!=null)
    {
	    _target.addComponent(component);
    }
  }

}
