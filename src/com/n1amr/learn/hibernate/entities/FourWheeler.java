package com.n1amr.learn.hibernate.entities;

import javax.persistence.Entity;

@Entity(name = "amr_vehicle_fourwheeler")
public class FourWheeler extends Vehicle {
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
