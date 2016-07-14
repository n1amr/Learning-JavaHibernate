package com.amr.hibernate;

import com.amr.hibernate.entities.Address;
import com.amr.hibernate.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {
	public static void main(String[] args) {
		Address address = new Address("street", "city", "state", "pincode");
		User user = new User(1, "Amr Alaa", new Date());
		user.getAddresses().add(address);


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
		session = null;

		user = null;
		address = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		user = (User) session.get(User.class, 1);
		System.out.println(user.getUserName());

		address = (Address) user.getAddresses().toArray()[0];
		System.out.println(address.getCity());

		session.close();


	}
}
