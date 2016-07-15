package com.amr.hibernate.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "amr_vehicles")
public class Vehicle {
	private int id;
	private String name;

	public Vehicle() {
	}

	public Vehicle(String name) {
		this.name = name;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
