/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.persistence.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate.type.EncryptedStringType;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wicketpraxis.persistence.DoInterface;

@TypeDef(
    name="encryptedString", 
    typeClass=EncryptedStringType.class, 
    parameters= {
        @Parameter(name="encryptorRegisteredName", value="myHibernateStringEncryptor")
    }
)

@Entity
@Table(name="Users")
public class User implements DoInterface<Integer>
{
	private static final Logger _logger = LoggerFactory.getLogger(User.class);
	
	Integer _id;
	
	String _eMail;
	
	String _name;
	
	String _cryptedPassword;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId()
	{
		return _id;
	}
	
	public void setId(Integer id)
	{
		_id=id;
	}
	
	@Column(nullable=false,unique=true,name="email")
	@Index(name="email")
	public String getEMail()
	{
		return _eMail;
	}
	
	public void setEMail(String mail)
	{
		_eMail = mail;
	}
	
	@Column(nullable=false)
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	@Column(nullable=false,length=128)
	@Type(type="encryptedString")
	protected void setCryptedPassword(String internalPassword)
	{
		_cryptedPassword = internalPassword;
	}
	
	protected String getCryptedPassword()
	{
		return _cryptedPassword;
	}
	
	@Transient
	public void setPassword(String plainPassword)
	{
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(plainPassword);
//		_logger.error("Password: {}",encryptedPassword);
		_cryptedPassword=encryptedPassword;
	}
	
	@Transient
	public boolean isPasswordValid(String plainPassword)
	{
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = _cryptedPassword;
//		_logger.error("Password: {}",encryptedPassword);
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}
}
