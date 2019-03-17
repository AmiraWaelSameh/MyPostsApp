package com.myposts.springboot.rest.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String password;
	private Date dateCreated;

	public User() {
		// empty constructor
	}

	public User(String userName, String password, Date dateCreated) {
		setUserName(userName);
		setPassword(password);
		setDateCreated(dateCreated);
	}

	public User(String userName) {
		setUserName(userName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
