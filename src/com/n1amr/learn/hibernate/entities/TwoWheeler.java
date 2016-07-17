package com.n1amr.learn.hibernate.entities;

import javax.persistence.Entity;

@Entity(name = "amr_vehicle_twowheeler")
public class TwoWheeler extends Vehicle {
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
