package com.n1amr.learn.hibernate.entities;

import javax.persistence.Entity;

@Entity(name = "amr_vehicle_two_wheeler")
public class TwoWheeler extends Vehicle {
	private int weight;

	public TwoWheeler() {
	}

	public TwoWheeler(String name, int weight) {
		super(name);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
