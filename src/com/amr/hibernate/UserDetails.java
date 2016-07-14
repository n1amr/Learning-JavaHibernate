package com.amr.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "amr_user")
public class UserDetails {

	@Id
	@Column(name = "id")
	private int userId;
	@Column(name = "name")
	private String userName;

	public String getUserName () {
		return userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}

	public int getUserId () {
		return userId;
	}

	public void setUserId (int userId) {
		this.userId = userId;
	}
}
