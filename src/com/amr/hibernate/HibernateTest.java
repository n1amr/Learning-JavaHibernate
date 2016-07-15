package com.amr.hibernate;

import com.amr.hibernate.entities.Address;
import com.amr.hibernate.entities.Item;
import com.amr.hibernate.entities.User;
import com.amr.hibernate.entities.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Set;

public class HibernateTest {
	public static void main(String[] args) {
		Address address = new Address("street", "city", "state", "pincode");
		Vehicle vehicle = new Vehicle("vehicle2");
		User user = new User(1, "Amr Alaa", new Date());
		user.getAddresses().add(address);
		user.setVehicle(vehicle);
		user.getItems().add(new Item("item1"));
		user.getItems().add(new Item("item2"));


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();

//	  Retrieve session
		session = sessionFactory.openSession();

		user = (User) session.get(User.class, 1);
		System.out.println("Retrieved user 1 (" + user.getUserName() + ")");
		Set<Address> addresses = user.getAddresses();

		System.out.println("\nUser has " + addresses.size() + " addresses:");
		for (Address address1 : user.getAddresses())
			System.out.println(address1.getStreet());

		vehicle = user.getVehicle();
		System.out.println("\nUser has vehicle: " + vehicle.getName());

		System.out.println("\nUser has " + user.getItems().size() + " items:");
		for (Item item : user.getItems())
			System.out.println(item.getName());

		session.close();

	}
}
