package com.amr.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "amr_user")
public class UserDetails {

	private int userId;
	private String userName;

	@Column(name = "name")
	public String getUserName () {
		return userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}

	@Id
	@Column(name = "id")
	public int getUserId () {
		return userId;
	}

	public void setUserId (int userId) {
		this.userId = userId;
	}
}
