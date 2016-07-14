package com.amr.hibernate.entities;

import com.amr.hibernate.entities.Address;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "amr_user")
public class User {

	private int userId;
	private String userName;
	private Date joinedDate;
	private Address address;
	private String description;

	public User() {
	}

	public User(int userId, String userName, Date joinedDate, Address address, String description) {
		this.userId = userId;
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.address = address;
		this.description = description;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue
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

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
