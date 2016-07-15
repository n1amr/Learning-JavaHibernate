package com.amr.learn.hibernate.entities;

import javax.persistence.*;

@Entity(name = "amr_items")
public class Item {
	private int id;
	private String name;
	private User owner;

	public Item() {
	}

	public Item(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_user_id")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
