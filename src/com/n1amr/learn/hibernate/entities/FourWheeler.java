package com.n1amr.learn.hibernate.entities;

import javax.persistence.Entity;

@Entity(name = "amr_vehicle_four_wheeler")
public class FourWheeler extends Vehicle {
	private int speed;

	public FourWheeler() {
	}

	public FourWheeler(String name, int speed) {
		super(name);
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
