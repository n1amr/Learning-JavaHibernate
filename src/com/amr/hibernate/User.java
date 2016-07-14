package com.amr.hibernate;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "amr_user")
public class User {

	private int userId;
	private String userName;
	private Date joinedDate;
	private String Address;
	private String description;

	public User() {
	}

	public User(int userId, String userName, Date joinedDate, String address, String description) {
		this.userId = userId;
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.Address = address;
		this.description = description;
	}

	@Id
	@Column(name = "id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.DATE)
	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
