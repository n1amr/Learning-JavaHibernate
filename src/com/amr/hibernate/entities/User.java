package com.amr.hibernate.entities;

import javax.persistence.*;
import java.util.*;


@Entity(name = "amr_users")
public class User {

	private int userId;
	private String userName;
	private Date joinedDate;
	private String description;
	private Set<Address> addresses = new HashSet<>();
	private Vehicle vehicle;
	private Collection<Item> items = new ArrayList<>();
	private Collection<User> following = new HashSet<>();
	private Collection<Vehicle> rentedVehicles = new HashSet<>();

	public User() {
	}

	public User(String userName, Date joinedDate) {
		this.userName = userName;
		this.joinedDate = joinedDate;
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


	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@ElementCollection
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "amr_users_following",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "following_user_id")
	)
	public Collection<User> getFollowing() {
		return following;
	}

	public void setFollowing(Collection<User> following) {
		this.following = following;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "amr_users_vehicles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "vehicle_id")
	)
	public Collection<Vehicle> getRentedVehicles() {
		return rentedVehicles;
	}

	public void setRentedVehicles(Collection<Vehicle> rentedVehicles) {
		this.rentedVehicles = rentedVehicles;
	}
}
