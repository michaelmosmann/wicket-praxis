/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.beans;

import java.text.MessageFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.wicketpraxis.persistence.DoInterface;

@Entity
@Table(name="Articles")
public class Article implements DoInterface<Integer>
{
	Integer _id;
	
	User _user;

	String _title;
	
	String _text;
	
	Date _created;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId()
	{
		return _id;
	}

	public void setId(Integer id)
	{
		_id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	public User getUser()
	{
		return _user;
	}
	
	public void setUser(User user)
	{
		_user = user;
	}
	
	@Column(nullable=false)
	public String getTitle()
	{
		return _title;
	}

	public void setTitle(String title)
	{
		_title = title;
	}

	@Column(nullable=false,length=4096)
	public String getText()
	{
		return _text;
	}

	public void setText(String text)
	{
		_text = text;
	}

	@Column(nullable=false)
	public Date getCreated()
	{
		return _created;
	}

	public void setCreated(Date created)
	{
		_created = created;
	}
	
	@Override
	public String toString()
	{
		return MessageFormat.format("Title: {0} (Created: {1})", _title,_created);
	}
	
}
