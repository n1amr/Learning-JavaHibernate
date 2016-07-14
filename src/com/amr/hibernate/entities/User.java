package com.amr.hibernate.entities;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "amr_user")
public class User {

	private int userId;
	private String userName;
	private Date joinedDate;
	private Address homeAddress;
	private Address workAddress;
	private String description;

	public User() {
	}

	public User(int userId, String userName, Date joinedDate, Address address, String description) {
		this.userId = userId;
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.homeAddress = address;
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
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address address) {
		this.homeAddress = address;
	}


	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "work_city")),
		@AttributeOverride(name = "pinCode", column = @Column(name = "work_pinCode")),
		@AttributeOverride(name = "state", column = @Column(name = "work_state")),
		@AttributeOverride(name = "street", column = @Column(name = "work_street")),
	})
	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}


	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
